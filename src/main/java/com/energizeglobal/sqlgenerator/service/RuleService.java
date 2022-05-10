package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.RuleEntity;
import com.energizeglobal.sqlgenerator.dto.RuleDTO;
import com.energizeglobal.sqlgenerator.mapper.RuleMapper;
import com.energizeglobal.sqlgenerator.repository.RuleRepository;
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
public class RuleService {

    private Boolean dbAction = false;
    private final RuleRepository ruleRepository;

    private String FILE_PATH = "src/main/resources/sql_scripts/";
    private String INSERT_FILE_NAME = "rule.sql";
    String ROLLBACK_FILE_NAME = "rule_rollback.sql";
    private String path = FILE_PATH + INSERT_FILE_NAME;

    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Transactional(readOnly = true)
    public List<RuleEntity> getAllRules() {
        List<RuleEntity> ruleList = ruleRepository.findAll();
        return ruleList;
    }

    @Transactional(readOnly = true)
    public RuleDTO findById(Long id) {
        RuleEntity ruleEntity = ruleRepository.getById(id);
        return RuleMapper.entityToDto(ruleEntity);
    }

    @Transactional
    public String generateInsertSqlScript(RuleDTO ruleDto) {
        RuleEntity ruleEntity = RuleMapper.dtoToEntity(ruleDto);
        String queryType = "INSERT INTO rule  ( " +
                "id, " +
                "name, " +
                "orderRule, " +
                "description )";

        String queryValue = "  VALUES (" +
                ruleEntity.getId() + ", '" +
                ruleEntity.getName() + "', " +
                ruleEntity.getOrderRule() + ", '" +
                ruleEntity.getDescription() + "');";

        String sqlInsert = queryType + queryValue;

        pathGenerator(sqlInsert);

        generateSqlScriptForInsertRollback(ruleEntity.getId());

        if (dbAction)
            ruleRepository.save(ruleEntity);

        return INSERT_FILE_NAME;
    }

    public String generateSqlScriptForInsertRollback(Long id) {

        String deleteQuery = "\n" +
                "START TRANSACTION; \n" +
                "SET FOREIGN_KEY_CHECKS = 0; \n" +
                "DELETE FROM rule WHERE id = " + id + ";\n" +
                "SET FOREIGN_KEY_CHECKS = 1; \n" +
                "COMMIT;";

        pathGenerator(deleteQuery);

        return ROLLBACK_FILE_NAME;
    }

    private void pathGenerator(String sql) {

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
            throw new RuntimeException("IOException: " + e.getMessage());
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
