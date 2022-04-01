package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.service.RollbackSqlScript;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class RollbackSqlScriptServiceImpl implements RollbackSqlScript {

   final static String FILE_PATH = "src/main/resources/sql_scripts/";
   final static String FILE_NAME = "rollback_query.sql";

    @Override
    public void rollbackScript(String rollbackScript) {

        String path = FILE_PATH + FILE_NAME;

        // get the current date
        LocalDateTime d = LocalDateTime.now();

        Path newFilePath = Paths.get(path);
        try {
            if (Files.exists(newFilePath)) {
                rollbackScript = System.getProperty("line.separator") + rollbackScript;
                Files.write(
                        newFilePath, rollbackScript.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } else {
                Path fileDirectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDirectory);
                Files.write(newFilePath, d.toString().getBytes(StandardCharsets.UTF_8));
                Files.write(newFilePath, rollbackScript.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
