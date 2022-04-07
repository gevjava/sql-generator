package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.service.GenerateSqlScriptService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class GenerateSqlScriptServiceImpl implements GenerateSqlScriptService {

  final static String FILE_PATH = "src/main/resources/sql_scripts/";
  final static String FILE_NAME = "insert_query.sql";

  @Override
  public void insertSqlScript(String sqlInsert) {

    String path = FILE_PATH + FILE_NAME;

    Path newFilePath = Paths.get(path);
    try {
      if (Files.exists(newFilePath)) {
        sqlInsert = System.getProperty("line.separator") + sqlInsert;
        Files.write(
            newFilePath, sqlInsert.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
      } else {
        Path fileDirectory = Paths.get(FILE_PATH);
        Files.createDirectories(fileDirectory);
        Files.write(newFilePath, sqlInsert.getBytes(StandardCharsets.UTF_8));
        Files.write(newFilePath, sqlInsert.getBytes(StandardCharsets.UTF_8));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
