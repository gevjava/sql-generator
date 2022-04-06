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

    private final SubIssuerRepository subIssuerRepository;

    String FILE_PATH = "src/main/resources/sql_scripts/";
    String FILE_NAME = "subissuer_subinsert.sql";
    String path = FILE_PATH + FILE_NAME;

    public SubIssuerService(SubIssuerRepository subIssuerRepository) {

        this.subIssuerRepository = subIssuerRepository;
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
                "authentMeans , " +
                "name,  " +
                "label , " +
                "personnalDataStorage, " +
                "resetBackupsIfSuccess)";

        String queryValue = "  VALUES ('" +
                subIssuer.getAcsId() + "', " +
                subIssuer.getAuthenticationTimeOut() + ", '" +
                subIssuer.getDefaultLanguage() + "', '" +
                subIssuer.getCode() + "', '" +
                subIssuer.getCodeSvi() + "', '" +
                subIssuer.getCurrencyCode() + "', '" +
                subIssuer.getAuthentMeans() + "', '" +
                subIssuer.getName() + "', '" +
                subIssuer.getLabel() + "', " +
                subIssuer.getPersonnalDataStorage() + ", " +
                subIssuer.getResetBackupsIfSuccess() + ");";

        String sqlInsert = queryType + queryValue;

        pathGenerator(sqlInsert);

        return FILE_NAME;
    }

    public String generateUpdateSqlScript(SubIssuerDto subIssuerDto) {

        SubIssuer subIssuer = SubissuerMapping.dtoToEntity(subIssuerDto);
        String queryUpdate = "UPDATE subissuer SET " +
                "acsId = '" + subIssuerDto.getAcsId() + "', " +
                "authenticationTimeOut = " + subIssuerDto.getAuthenticationTimeOut() + ", " +
                "defaultLanguage = '" + subIssuerDto.getDefaultLanguage() + "', " +
                "code = " + subIssuerDto.getCode() + ", " +
                "codeSvi = " + subIssuerDto.getCodeSvi() + ", " +
                "currencyCode = " + subIssuerDto.getCurrencyCode() + ", " +
                "authentMeans = '" + subIssuerDto.getAuthentMeans() + "', " +
                "name = '" + subIssuerDto.getName() + "', " +
                "label = '" + subIssuerDto.getLabel() + "', " +
                "personnalDataStorage = " + subIssuerDto.getPersonnalDataStorage() + " " +
                "resetBackupsIfSuccess = " + subIssuerDto.getResetBackupsIfSuccess() + " " +
                " WHERE code = " + subIssuerDto.getCode() + ";";
        pathGenerator(queryUpdate);

        System.out.println(subIssuerRepository.updateSubIssuer(subIssuer.getCode(),
                subIssuer.getAcsId(),
                subIssuer.getAuthenticationTimeOut(),
                subIssuer.getDefaultLanguage(),
                subIssuer.getCodeSvi(),
                subIssuer.getCurrencyCode(),
                subIssuer.getAuthentMeans(),
                subIssuer.getName(),
                subIssuer.getLabel(),
                subIssuer.getPersonnalDataStorage(),
                subIssuer.getResetBackupsIfSuccess()));

        return FILE_NAME;
    }


    public String generateDeleteSqlScript(String code) {

        String deleteQuery = "\nSTART TRANSACTION; \n" +
                             "SET FOREIGN_KEY_CHECKS = 0; \n" +
                             "DELETE FROM subissuer WHERE code = " + code + ";\n" +
                             "SET FOREIGN_KEY_CHECKS = 1; \n" +
                             "COMMIT;";
        pathGenerator(deleteQuery);
      // TODO  subIssuerRepository.deleteByCode(code);
        return FILE_NAME;
    }

    private void pathGenerator(String sql) {
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