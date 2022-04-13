package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.domain.IssuerEntity;
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

    private final GenerateSqlScriptServiceImpl generateSqlScriptServiceImpl;
    private final Logger log = LoggerFactory.getLogger(IssuerServiceImpl.class);

    private String FILE_PATH = "src/main/resources/sql_scripts/";
    private String FILE_NAME = "insert.sql";

    private final IssuerRepository issuerRepository;

    private final DownloadFileServiceServiceImpl downloadFileServiceImpl;

    public IssuerServiceImpl(
            IssuerRepository issuerRepository,
            GenerateSqlScriptServiceImpl generateSqlScriptServiceImpl,
            DownloadFileServiceServiceImpl downloadFileServiceImpl) {
        this.issuerRepository = issuerRepository;
        this.generateSqlScriptServiceImpl = generateSqlScriptServiceImpl;
        this.downloadFileServiceImpl = downloadFileServiceImpl;
    }

    @Transactional(readOnly = true)
    public List<IssuerEntity> getAllIssuer() {

        return issuerRepository.findAll();
    }

    public String generateInsertSqlScript(IssuerDTO dto) {

        String sqlInsert =
                "INSERT INTO IssuerEntity (code, createdBy, description, name) VALUES ('"
                        + dto.getCode()
                        + "', '"
                        + dto.getData().getCreatedBy()
                        + "', '"
                        + dto.getData().getDescription()
                        + "', '"
                        + dto.getData().getName()
                        + "');";

        generateSqlScriptServiceImpl.insertSqlScript(sqlInsert, FILE_NAME);
        return FILE_NAME;
    }

    public Resource getDownloadFileServiceImpl() {
        return downloadFileServiceImpl.downloadFile(FILE_NAME, FILE_PATH);
    }
}
