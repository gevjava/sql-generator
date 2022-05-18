package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.RuleCondition;
import com.energizeglobal.sqlgenerator.dto.RuleConditionDTO;
import com.energizeglobal.sqlgenerator.mapper.RuleConditionMapper;
import com.energizeglobal.sqlgenerator.repository.RuleConditionRepository;
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
import java.time.Instant;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;

@Service
public class RuleConditionService {

    private Boolean dbConnection = false;
    private final RuleConditionRepository repository;
    private String MAIN_FILE_NAME = "ruleCondition.sql";
    private String FILE_PATH = "src/main/resources/sql_scripts/";
    private String ROLLBACK_FILE_NAME = "ruleCondition_rollback.sql";
    private String mainPath = FILE_PATH + MAIN_FILE_NAME;
    private String rollbackPath = FILE_PATH + ROLLBACK_FILE_NAME;
    String thisMomentTime = Instant.now().toString().replace("T", " ").replace("Z", " ");

    public RuleConditionService(RuleConditionRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public RuleConditionDTO findById(Long id) {
        RuleCondition condition = repository.getById(id);
        return RuleConditionMapper.entityToDto(condition);
    }

    @Transactional(readOnly = true)
    public List<RuleCondition> getAllConditions() {
        List<RuleCondition> conditions = repository.findAll();
        return conditions;
    }

    @Transactional
    public String generateInsertSqlScript(RuleConditionDTO ruleConditionDto) {

        RuleCondition ruleCondition = RuleConditionMapper.dtoToEntity(ruleConditionDto);
        ruleCondition.setCreationDate(Instant.now());
        String queryType = "INSERT INTO rulecondition  ( " +
                "createdBy, " +
                "creationDate, " +
                "description, " +
                "lastUpdateBy, " +
                "lastUpdateDate, " +
                "name, " +
                "updateState, " +
                "fk_id_rule )";

        String queryValue = " \n" +
                "VALUES (" + " '" +
                ruleCondition.getCreatedBy() + "', '" +
                thisMomentTime + "', '" +
                ruleCondition.getDescription() + "', '" +
                ruleCondition.getLastUpdateBy() + "', '" +
                thisMomentTime + "', '" +
                ruleCondition.getName() + "', '" +
                ruleCondition.getUpdateState() + "', " +
                ruleCondition.getRule().getId() + ");";

        String sqlInsert = queryType + queryValue;
        pathGenerator(sqlInsert, mainPath);

        generateSqlScriptForInsertRollback(ruleCondition.getId());

        if (dbConnection)
            repository.save(ruleCondition);

        return MAIN_FILE_NAME;
    }

    private String generateSqlScriptForInsertRollback(Long id) {

        String deleteQuery = "\n" +
                "START TRANSACTION; \n" +
                "SET FOREIGN_KEY_CHECKS = 0; \n" +
                "DELETE FROM rulecondition WHERE id = " + id + ";\n" +
                "SET FOREIGN_KEY_CHECKS = 1; \n" +
                "COMMIT;";

        pathGenerator(deleteQuery, rollbackPath);

        return ROLLBACK_FILE_NAME;
    }

    @Transactional
    public String generateUpdateSqlScript(RuleConditionDTO ruleConditionDto) {
        ruleConditionDto.setLastUpdateDate(Instant.now());
        RuleCondition oldRuleCondition = repository.getById(ruleConditionDto.getId());
        RuleCondition newRuleCondition = RuleConditionMapper.dtoToEntity(ruleConditionDto);

        String queryUpdate = "UPDATE rulecondition SET " +
                "createdBy = '" + ruleConditionDto.getCreatedBy() + "', " +
                "creationDate = '" + ruleConditionDto.getCreationDate().toString().replace("T", " ")
                .replace("Z", " ") + "', " +
                "description = '" + ruleConditionDto.getDescription() + "', " +
                "lastUpdateBy = '" + ruleConditionDto.getLastUpdateBy() + "', " +
                "lastUpdateDate = '" + thisMomentTime + "', " +
                "name = '" + ruleConditionDto.getName() + "', " +
                "updateState = '" + ruleConditionDto.getUpdateState() + "' " +
                " WHERE id = " + ruleConditionDto.getId() + ";";

        pathGenerator(queryUpdate, mainPath);

        generateSqlScriptForUpdateRollback(oldRuleCondition);

        if (dbConnection)
            repository.save(newRuleCondition);

        return MAIN_FILE_NAME;
    }

    private String generateSqlScriptForUpdateRollback(RuleCondition oldRuleCondition) {

        String queryUpdate = "UPDATE rulecondition SET " +
                "createdBy = '" + oldRuleCondition.getCreatedBy() + "', " +
                "creationDate = '" + oldRuleCondition.getCreationDate().toString().replace("T", " ")
                .replace("Z", " ") + "', " +
                "description = '" + oldRuleCondition.getDescription() + "', " +
                "lastUpdateBy = '" + oldRuleCondition.getLastUpdateBy() + "', " +
                "lastUpdateDate = '" + thisMomentTime + "', " +
                "name = '" + oldRuleCondition.getName() + "', " +
                "updateState = '" + oldRuleCondition.getUpdateState() + "' " +
                " WHERE id = " + oldRuleCondition.getId() + ";";

        pathGenerator(queryUpdate, rollbackPath);

        return ROLLBACK_FILE_NAME;
    }

    @Transactional
    public String generateDeleteSqlScript(Long id) {

        RuleConditionDTO ruleCondition = findById(id);

        String deleteQuery = "\n" +
                "START TRANSACTION; \n" +
                "SET FOREIGN_KEY_CHECKS = 0; \n" +
                "DELETE FROM rulecondition WHERE id = " + id + ";\n" +
                "SET FOREIGN_KEY_CHECKS = 1; \n" +
                "COMMIT;";

        pathGenerator(deleteQuery, mainPath);

        generateSqlScriptForDeleteRollback(ruleCondition);

        if (dbConnection)
            repository.deleteById(id);

        return MAIN_FILE_NAME;
    }

    private String generateSqlScriptForDeleteRollback(RuleConditionDTO ruleConditionDto) {

        String queryType = "INSERT INTO rulecondition  ( " +
                "createdBy, " +
                "creationDate, " +
                "description, " +
                "lastUpdateBy, " +
                "lastUpdateDate, " +
                "name, " +
                "updateState )";

        String queryValue = " \n" +
                " VALUES (" + " '" +
                ruleConditionDto.getCreatedBy() + "', '" +
                Instant.now().toString().replace("T", " ")
                        .replace("Z", " ") + "', '" +
                ruleConditionDto.getDescription() + "', '" +
                ruleConditionDto.getLastUpdateBy() + "', '" +
                ruleConditionDto.getLastUpdateDate() + "', '" +
                ruleConditionDto.getName() + "', '" +
                ruleConditionDto.getUpdateState() + "');";

        String sqlInsert = queryType + queryValue;

        pathGenerator(sqlInsert, rollbackPath);

        return ROLLBACK_FILE_NAME;
    }


    private void pathGenerator(String sql, String path) {

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
