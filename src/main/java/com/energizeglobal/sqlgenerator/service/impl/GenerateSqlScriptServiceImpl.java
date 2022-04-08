package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.service.GenerateSqlScriptService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

@Service
public class GenerateSqlScriptServiceImpl implements GenerateSqlScriptService {

    final static String FILE_PATH = "src/main/resources/sql_scripts/";


    @Override
    public void insertSqlScript(String insertQuery,String fileName) {

        String path = FILE_PATH + fileName;

        String data = "--" + LocalDateTime.now().toString();


        Path newFilePath = Paths.get(path);
        try {
            if (Files.exists(newFilePath)) {
                data = System.getProperty("line.separator") + data;
                insertQuery = System.getProperty("line.separator") + insertQuery;

                Files.write(
                        newFilePath, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.write(
                        newFilePath, insertQuery.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } else {
                Path fileDirectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDirectory);
                Files.write(
                        newFilePath, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.write(newFilePath, insertQuery.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
