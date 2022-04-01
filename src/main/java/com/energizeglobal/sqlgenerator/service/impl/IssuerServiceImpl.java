package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.domain.Issuer;
import com.energizeglobal.sqlgenerator.dto.IssuerDTO;
import com.energizeglobal.sqlgenerator.repository.IssuerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IssuerServiceImpl {

  private final GenerateSqlScriptServiceServiceImpl generateSqlScriptServiceImpl;
  private final Logger log = LoggerFactory.getLogger(IssuerServiceImpl.class);

  private String FILE_PATH = "src/main/resources/sql_scripts/";
  private String FILE_NAME = "insert.sql";

  private final IssuerRepository issuerRepository;

  private final DownloadFileServiceImpl downloadFileServiceImpl;

  public IssuerServiceImpl(
      IssuerRepository issuerRepository,
      GenerateSqlScriptServiceServiceImpl generateSqlScriptServiceImpl,
      DownloadFileServiceImpl downloadFileServiceImpl) {
    this.issuerRepository = issuerRepository;
    this.generateSqlScriptServiceImpl = generateSqlScriptServiceImpl;
    this.downloadFileServiceImpl = downloadFileServiceImpl;
  }

  @Transactional(readOnly = true)
  public List<Issuer> getAllIssuer() {

    return issuerRepository.findAll();
  }

  public String generateInsertSqlScript(IssuerDTO dto) {

    String sqlInsert =
        "INSERT INTO Issuer (code, createdBy, description, name) VALUES ('"
            + dto.getCode()
            + "', '"
            + dto.getCreatedBy()
            + "', '"
            + dto.getDescription()
            + "', '"
            + dto.getName()
            + "');";

    generateSqlScriptServiceImpl.insertSqlScript(sqlInsert);
    return FILE_NAME;
  }

  public Resource getDownloadFileServiceImpl() {
    return downloadFileServiceImpl.downloadFile(FILE_NAME, FILE_PATH);
  }
}
