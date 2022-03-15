package com.energizeglobal.sqlgenerator.service;
import java.io.IOException;
import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;
import com.energizeglobal.sqlgenerator.mapping.SubissuerMapping;
import com.energizeglobal.sqlgenerator.repository.SubIssuerRepository;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.util.List;

@Service
public class SubIssuerService {

    private final Logger log = LoggerFactory.getLogger(SubIssuerService.class);

    private final SubIssuerRepository subIssuerRepository;

    String FILE_PATH = "src/main/resources/sql_scripts/";
    String FILE_NAME = "subissuer_subinsert.sql";

    public SubIssuerService(SubIssuerRepository subIssuerRepository) {

        this.subIssuerRepository = subIssuerRepository;
    }

    @Transactional(readOnly = true)
    public List<SubIssuer> getAllSubIssuer() {

        List<SubIssuer> subIssuerList = subIssuerRepository.findAll();

        return subIssuerList;
    }


    public String generateInsertSqlScript(SubIssuerDto dto) {

        SubIssuer subIssuer = SubissuerMapping.dtoToEntity(dto);

        String sqlInsert = "INSERT INTO subissuer (name, code, authentMeans ) VALUES ('" +
                subIssuer.getName() + "', '" +
                subIssuer.getCode() + "', '" +
                subIssuer.getAuthentMeans() + "');";

        String path = FILE_PATH + FILE_NAME;
        Path newFilePath = Paths.get(path);
        try {
            if (Files.exists(newFilePath)) {
                sqlInsert = System.getProperty("line.separator") + sqlInsert;
                Files.write(newFilePath, sqlInsert.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } else {
                Path fileDiectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDiectory);
                Files.write(newFilePath, sqlInsert.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FILE_NAME;
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