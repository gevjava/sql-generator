package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.SubIssuerEntity;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;
import com.energizeglobal.sqlgenerator.mapper.SubissuerMapping;
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

    private boolean dbAction = false;
    private final SubIssuerRepository subIssuerRepository;
    private final SubissuerRollbackService rollbackService;


    private final String FILE_PATH = "src/main/resources/sql_scripts/";
    private final String INSERT_FILE_NAME = "data.sql";
    private String path = FILE_PATH + INSERT_FILE_NAME;

    public SubIssuerService(SubIssuerRepository subIssuerRepository, SubissuerRollbackService rollbackService) {

        this.subIssuerRepository = subIssuerRepository;
        this.rollbackService = rollbackService;
    }

    @Transactional(readOnly = true)
    public List<SubIssuerEntity> getAllSubIssuer() {
        List<SubIssuerEntity> subIssuerEntityList = subIssuerRepository.findAll();
        return subIssuerEntityList;
    }

    public SubIssuerDto findByCode(String code) {
        SubIssuerEntity subIssuerEntity = subIssuerRepository.findByCode(code);
        return SubissuerMapping.entityToDto(subIssuerEntity);
    }

    @Transactional
    public String generateInsertSqlScript(SubIssuerDto dto) {

        SubIssuerEntity subIssuerEntity = SubissuerMapping.dtoToEntity(dto);

        String queryType = "INSERT INTO subissuer  ( " +
                "acsId, " +
                "authenticationTimeOut, " +
                "defaultLanguage, " +
                "code, " +
                "codeSvi, " +
                "currencyCode, " +
                "name, " +
                "label, " +
                "authentMeans, " +
                "personnalDataStorage, " +
                "resetBackupsIfSuccess," +
                "resetChoicesIfSuccess, " +
                "manageBackupsCombinedAmounts, " +
                "manageChoicesCombinedAmounts, " +
                "hubMaintenanceModeEnabled )";

        String queryValue = "  VALUES ('" +
                subIssuerEntity.getAcsId() + "', " +
                subIssuerEntity.getAuthenticationTimeOut() + ", '" +
                subIssuerEntity.getDefaultLanguage() + "', '" +
                subIssuerEntity.getCode() + "', '" +
                subIssuerEntity.getCodeSvi() + "', '" +
                subIssuerEntity.getCurrencyCode() + "', '" +
                subIssuerEntity.getName() + "', '" +
                subIssuerEntity.getLabel() + "', '" +
                subIssuerEntity.getAuthentMeans() + "', " +
                subIssuerEntity.getPersonnalDataStorage() + ", " +
                subIssuerEntity.isResetBackupsIfSuccess() + ", " +
                subIssuerEntity.isResetChoicesIfSuccess() + ", " +
                subIssuerEntity.isManageBackupsCombinedAmounts() + ", " +
                subIssuerEntity.isManageChoicesCombinedAmounts() + ", " +
                subIssuerEntity.isHubMaintenanceModeEnabled() + ");";

        String sqlInsert = queryType + queryValue;

        InsertPathGenerator(sqlInsert);

        rollbackService.generateSqlScriptForInsertRollback(subIssuerEntity.getCode());

        if (dbAction)
            subIssuerRepository.save(subIssuerEntity);

        return INSERT_FILE_NAME;
    }

    @Transactional
    public String generateUpdateSqlScript(SubIssuerDto subIssuerDto) {
        SubIssuerEntity oldSubIssuerEntity = subIssuerRepository.findByCode(subIssuerDto.getCode());
        SubIssuerEntity newSubIssuerEntity = SubissuerMapping.dtoToEntity(subIssuerDto);
        newSubIssuerEntity.setId(oldSubIssuerEntity.getId());

        String queryUpdate = "UPDATE subissuer SET " +
                "acsId = '" + subIssuerDto.getAcsId() + "', " +
                "authenticationTimeOut = " + subIssuerDto.getAuthenticationTimeOut() + ", " +
                "defaultLanguage = '" + subIssuerDto.getDefaultLanguage() + "', " +
                "codeSvi = '" + subIssuerDto.getCodeSvi() + "', " +
                "currencyCode = '" + subIssuerDto.getCurrencyCode() + "', " +
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

        rollbackService.generateSqlScriptForUpdateRollback(oldSubIssuerEntity);
        if (dbAction)
            subIssuerRepository.save(newSubIssuerEntity);

        return INSERT_FILE_NAME;
    }

    @Transactional
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
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFilePath, UTF_8, APPEND)) {
                    bufferedWriter.write(sql);
                }
            } else {
                Path fileDirectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDirectory);
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFilePath, UTF_8)) {
                    bufferedWriter.write(sql);
                }
            }
        } catch (IOException e) {
            dbAction = false;
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