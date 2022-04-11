package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;
import com.energizeglobal.sqlgenerator.mapping.SubissuerMapping;
import com.energizeglobal.sqlgenerator.repository.SubIssuerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;

@Service
public class SubIssuerService {

    private final Logger log = LoggerFactory.getLogger(SubIssuerService.class);

    private Boolean dbAction = false;
    private final SubIssuerRepository subIssuerRepository;
    private final RollbackService rollbackService;

    String FILE_PATH = "src/main/resources/sql_scripts/";
    String INSERT_FILE_NAME = "subissuer_subinsert.sql";
    String path = FILE_PATH + INSERT_FILE_NAME;

    public SubIssuerService(SubIssuerRepository subIssuerRepository, RollbackService rollbackService) {

        this.subIssuerRepository = subIssuerRepository;
        this.rollbackService = rollbackService;
    }

    @Transactional(readOnly = true)
    public List<SubIssuer> getAllSubIssuer() {
        List<SubIssuer> subIssuerList = subIssuerRepository.findAll();
        return subIssuerList;
    }

    public SubIssuerDto findByCode(String code) {
        SubIssuer subIssuer = subIssuerRepository.findByCode(code);
        return SubissuerMapping.entityToDto(subIssuer);
    }

    public String generateInsertSqlScript(SubIssuerDto dto) {

        SubIssuer subIssuer = SubissuerMapping.dtoToEntity(dto);

        String queryType = "INSERT INTO subissuer  ( " +
                "acsId ," +
                "authenticationTimeOut," +
                " defaultLanguage , " +
                "code, " +
                "codeSvi ," +
                "currencyCode , " +
                "name,  " +
                "label , " +
                "authentMeans , " +
                "personnalDataStorage, " +
                "resetBackupsIfSuccess," +
                "resetChoicesIfSuccess, " +
                "manageBackupsCombinedAmounts," +
                " manageChoicesCombinedAmounts," +
                " hubMaintenanceModeEnabled )";

        String queryValue = "  VALUES ('" +
                subIssuer.getAcsId() + "', " +
                subIssuer.getAuthenticationTimeOut() + ", '" +
                subIssuer.getDefaultLanguage() + "', '" +
                subIssuer.getCode() + "', '" +
                subIssuer.getCodeSvi() + "', '" +
                subIssuer.getCurrencyCode() + "', '" +
                subIssuer.getName() + "', '" +
                subIssuer.getLabel() + "', '" +
                subIssuer.getAuthentMeans() + "', " +
                subIssuer.getPersonnalDataStorage() + ", " +
                subIssuer.getResetBackupsIfSuccess() + ", " +
                subIssuer.getResetChoicesIfSuccess() + ", " +
                subIssuer.getManageBackupsCombinedAmounts() + ", " +
                subIssuer.getManageChoicesCombinedAmounts() + ", " +
                subIssuer.getHubMaintenanceModeEnabled() + ");";

        String sqlInsert = queryType + queryValue;

        InsertPathGenerator(sqlInsert);

        rollbackService.generateSqlScriptForInsertRollback(subIssuer.getCode());

        if (dbAction)
            subIssuerRepository.save(subIssuer);

        return INSERT_FILE_NAME;
    }

    public String generateUpdateSqlScript(SubIssuerDto subIssuerDto) {
        SubIssuer oldSubIssuer = subIssuerRepository.findByCode(subIssuerDto.getCode());
        SubIssuer newSubIssuer = SubissuerMapping.dtoToEntity(subIssuerDto);
        newSubIssuer.setId(oldSubIssuer.getId());

        String queryUpdate = "UPDATE subissuer SET " +
                "acsId = '" + subIssuerDto.getAcsId() + "', " +
                "authenticationTimeOut = " + subIssuerDto.getAuthenticationTimeOut() + ", " +
                "defaultLanguage = '" + subIssuerDto.getDefaultLanguage() + "', " +
                "codeSvi = " + subIssuerDto.getCodeSvi() + ", " +
                "currencyCode = " + subIssuerDto.getCurrencyCode() + ", " +
                "name = '" + subIssuerDto.getName() + "', " +
                "label = '" + subIssuerDto.getLabel() + "', " +
                "authentMeans = '" + subIssuerDto.getAuthentMeans() + "', " +
                "personnalDataStorage = " + subIssuerDto.getPersonnalDataStorage() + ", " +
                "resetBackupsIfSuccess = " + subIssuerDto.getResetBackupsIfSuccess() + ", " +
                "resetChoicesIfSuccess = " + subIssuerDto.getResetChoicesIfSuccess() + ", " +
                "manageBackupsCombinedAmounts = " + subIssuerDto.getManageBackupsCombinedAmounts() + ", " +
                "manageChoicesCombinedAmounts = " + subIssuerDto.getManageChoicesCombinedAmounts() + ", " +
                "hubMaintenanceModeEnabled = " + subIssuerDto.getHubMaintenanceModeEnabled() + " " +
                " WHERE code = " + subIssuerDto.getCode() + ";";

        InsertPathGenerator(queryUpdate);

        rollbackService.generateSqlScriptForUpdateRollback(oldSubIssuer);
        if (dbAction)
            subIssuerRepository.save(newSubIssuer);

        return INSERT_FILE_NAME;
    }

    public String generateDeleteSqlScript(String code) {

        SubIssuerDto oldSubIssuer = findByCode(code);

        String deleteQuery = "\n" +
                "START TRANSACTION; \n" +
                "SET FOREIGN_KEY_CHECKS = 0; \n" +
                "DELETE FROM subissuer WHERE code = " + code + ";\n" +
                "SET FOREIGN_KEY_CHECKS = 1; \n" +
                "COMMIT;";
        InsertPathGenerator(deleteQuery);

        rollbackService.generateSqlScriptForDeleteRollback(oldSubIssuer);

        if (dbAction)
            subIssuerRepository.deleteByCode(code);

        return INSERT_FILE_NAME;
    }

    private void InsertPathGenerator(String sql) {
        Path newFilePath = Paths.get(path);
        try {
            if (Files.exists(newFilePath)) {
                sql = System.getProperty("line.separator") + sql;
                try (BufferedWriter bufferedWriter =
                             Files.newBufferedWriter(newFilePath, UTF_8, APPEND)) {
                    bufferedWriter.write(sql);
                }
            } else {
                Path fileDirectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDirectory);
                try (
                        BufferedWriter bufferedWriter =
                                Files.newBufferedWriter(newFilePath, UTF_8)) {
                    bufferedWriter.write(sql);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Resource downloadFile(String filename) {
        try {
            Path file = Paths.get(FILE_PATH).resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}