package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.Issuer;
import com.energizeglobal.sqlgenerator.dto.IssuerDTO;
import com.energizeglobal.sqlgenerator.repository.IssuerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
public class IssuerService {

    private final Logger log = LoggerFactory.getLogger(IssuerService.class);

    String FILE_PATH = "src/main/resources/sql_scripts/";
    String FILE_NAME = "issuer_insert.sql";

    private final IssuerRepository issuerRepository;

    public IssuerService(IssuerRepository issuerRepository) {
        this.issuerRepository = issuerRepository;
    }

    @Transactional(readOnly = true)
    public List<Issuer> getAllIssuer(){

        List<Issuer> issuerList = issuerRepository.findAll();

        return issuerList;
    }

    public String generateInsertSqlScript(IssuerDTO dto){

        String sqlInsert = "INSERT INTO Issuer (code, createdBy, description, name) VALUES ('"+dto.getCode()+"', '"+dto.getCreatedBy()+"', '"+dto.getDescription()+"', '"+dto.getName()+"');";

        String path = FILE_PATH + FILE_NAME;
        Path newFilePath = Paths.get(path);
        try {
            if(Files.exists(newFilePath)) {
                sqlInsert = System.getProperty("line.separator")+sqlInsert;
                Files.write(newFilePath, sqlInsert.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }
            else {
                Path fileDiectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDiectory);
                Files.write(newFilePath, sqlInsert.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FILE_NAME;
    }

    public Resource downloadFile(String filename){
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
