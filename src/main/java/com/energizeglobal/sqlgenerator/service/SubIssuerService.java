package com.energizeglobal.sqlgenerator.service;

import java.io.BufferedWriter;
import java.io.IOException;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;
import com.energizeglobal.sqlgenerator.mapping.SubissuerMapping;
import com.energizeglobal.sqlgenerator.repository.SubIssuerRepository;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

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

    public String deleteById(Long id) {

        String query = "DELETE FROM subissuer WHERE id ='" + id + "';";
        pathGenerator(query);
        subIssuerRepository.deleteById(id);
        return FILE_NAME;
    }

    public SubIssuerDto findById(Long id) {
        SubIssuer subIssuer = subIssuerRepository.getById(id);
        SubIssuerDto subIssuerDto = SubissuerMapping.entityToDto(subIssuer);
        return subIssuerDto;
    }


    public String generateInsertSqlScript(SubIssuerDto dto) {

        SubIssuer subIssuer = SubissuerMapping.dtoToEntity(dto);

        String queryType = "INSERT INTO subissuer  ( acsId ,authenticationTimeOut," +
                " defaultLanguage , code, codeSvi ," +
                " currencyCode , name,  label , authenticationMeans )";

        String queryValue = " \n  VALUES ('" +
                subIssuer.getAcsId() + "', " +
                subIssuer.getAuthenticationTimeOut() + ", '" +
                subIssuer.getDefaultLanguage() + "', '" +
                subIssuer.getCode() + "', '" +
                subIssuer.getCodeSvi() + "', '" +
                subIssuer.getCurrencyCode() + "', '" +
                subIssuer.getPersonnalDataStorage() + "', '" +
                subIssuer.getName() + "', '" +
                subIssuer.getLabel() + "', '" +
                subIssuer.getAuthentMeans() + "');";

        String sqlInsert = queryType + queryValue;

        pathGenerator(sqlInsert);

        return FILE_NAME;
    }

    //TODO
    public String generateUpdateSqlScript(String id, SubIssuerDto dto) {
        SubIssuer subIssuer = SubissuerMapping.dtoToEntity(dto);
        // SubIssuer s = subIssuerRepository.getById(subIssuer.getId());
        // SubIssuer subIssuer2 = subIssuerRepository.getById(SubissuerMapping.dtoToEntity(dto).getId());


        String queryUpdate = "UPDATE subissuer SET " +
                "'acsId' = '" + subIssuer.getAcsId() + "', " +
                "'authenticationTimeOut' = " + subIssuer.getAuthenticationTimeOut() + ", " +
                "'defaultLanguage' = '" + subIssuer.getDefaultLanguage() + "', " +
                "'code' = '" + subIssuer.getCode() + "', " +
                "'codeSvi' = '" + subIssuer.getCodeSvi() + "', " +
                "'currencyCode' = '" + subIssuer.getCurrencyCode() + "', " +
                "'personnalDataStorage' = '" + subIssuer.getPersonnalDataStorage() + "', " +
                "'name' = '" + subIssuer.getName() + "', " +
                "'label' = '" + subIssuer.getLabel() + "', " +
                "'authentMeans' = '" + subIssuer.getAuthentMeans() + "' " +
                " WHERE `id` = `" + id + "`;";


        pathGenerator(queryUpdate);

        return FILE_NAME;
    }

    public String generateDeleteSqlScript(String id) {

        String queryDelete = "DELETE FROM subissuer WHERE id = " + id + ";";

        pathGenerator(queryDelete);

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