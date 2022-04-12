package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.domain.AuthentMeansEntity;
import com.energizeglobal.sqlgenerator.dto.AuthentMeansDTO;
import com.energizeglobal.sqlgenerator.mapper.Mapping;
import com.energizeglobal.sqlgenerator.repository.AuthentMeansRepository;
import com.energizeglobal.sqlgenerator.service.AuthentMeansService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthentMeansServiceImpl implements AuthentMeansService {

    private static boolean activeDB = false;

    private final String INSERT_SQL_FILE_NAME = "insert_query.sql";

    private final String ROLLBACK_SQL_FILE_NAME = "rollback_query.sql";

    private final Mapping mappingAuthentMean;

    private final AuthentMeansRepository authentMeansRepository;

    private final GenerateSqlScriptServiceImpl generateSqlScriptService;

    private final DownloadFileServiceImpl downloadFileService;

    public AuthentMeansServiceImpl(Mapping mappingAuthentMean,
                                   AuthentMeansRepository authentMeansRepository,
                                   GenerateSqlScriptServiceImpl generateSqlScriptService,
                                   DownloadFileServiceImpl downloadFileService) {
        this.mappingAuthentMean = mappingAuthentMean;
        this.authentMeansRepository = authentMeansRepository;
        this.generateSqlScriptService = generateSqlScriptService;
        this.downloadFileService = downloadFileService;
    }


    @Override
    public List<AuthentMeansEntity> getAllAuthentMeans() {

        List<AuthentMeansEntity> authentMeansEntityList = authentMeansRepository.findAll();

        return authentMeansEntityList;
        //mappingAuthentMean.mapList(authentMeansEntityList, AuthentMeansDTO.class);
    }

    @Override
    public AuthentMeansDTO getByIdAuthentMean(Long id) {

        AuthentMeansEntity authentMeansEntity = authentMeansRepository.getById(id);

        return mappingAuthentMean.convertToDto(authentMeansEntity, AuthentMeansDTO.class);
    }

    @Override
    public String deleteAuthentMeanById(Long id) {

        AuthentMeansEntity authentMeansEntity = authentMeansRepository.getById(id);

        String deleteQuery = "DELETE FROM `authentmeans` WHERE id ='" + id + "';";

        String rollbackQuery = String.format("INSERT INTO `authentmeans` (createdBy, creationDate, description, lastUpdateBy, " +
                        "lastUpdateDate, name, updateState) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                authentMeansEntity.getCreatedBy(),
                authentMeansEntity.getCreationDate(),
                authentMeansEntity.getDescription(),
                authentMeansEntity.getLastUpdateBy(),
                authentMeansEntity.getLastUpdateDate(),
                authentMeansEntity.getName(),
                authentMeansEntity.getUpdateState());

        generateSqlScriptService.insertSqlScript(deleteQuery, INSERT_SQL_FILE_NAME);
        generateSqlScriptService.insertSqlScript(rollbackQuery, ROLLBACK_SQL_FILE_NAME);
        if (activeDB) {
            authentMeansRepository.deleteById(id);
        }
        return INSERT_SQL_FILE_NAME;
    }

    @Override
    public String updateAuthentMean(AuthentMeansDTO authentMeansDTO) {

        AuthentMeansEntity authentMeansEntity = mappingAuthentMean.convertToEntity(authentMeansDTO, AuthentMeansEntity.class);
        authentMeansEntity.setLastUpdateDate(LocalDateTime.now());
        authentMeansRepository.getById(authentMeansDTO.getId());
        String updateQuery = String.format("UPDATE `authentmeans` SET createdBy='%s', creationDate='%s', description='%s'," +
                        " lastUpdateBy='%s', lastUpdateDate='%s', name='%s', updateState='%s' WHERE id='%s';",
                authentMeansEntity.getCreatedBy(),
                authentMeansEntity.getCreationDate(),
                authentMeansEntity.getDescription(),
                authentMeansEntity.getLastUpdateBy(),
                authentMeansEntity.getLastUpdateDate(),
                authentMeansEntity.getName(),
                authentMeansEntity.getUpdateState(),
                authentMeansEntity.getId());

        AuthentMeansEntity authentMeansEntityRollback = authentMeansRepository.getById(authentMeansDTO.getId());
        String rollbackUpdateQuery = String.format("UPDATE `authentmeans` SET createdBy='%s', creationDate='%s', description='%s'," +
                        " lastUpdateBy='%s', lastUpdateDate='%s', name='%s', updateState='%s' WHERE id='%s';",
                authentMeansEntityRollback.getCreatedBy(),
                authentMeansEntityRollback.getCreationDate(),
                authentMeansEntityRollback.getDescription(),
                authentMeansEntityRollback.getLastUpdateBy(),
                authentMeansEntityRollback.getLastUpdateDate(),
                authentMeansEntityRollback.getName(),
                authentMeansEntityRollback.getUpdateState(),
                authentMeansEntityRollback.getId());


        generateSqlScriptService.insertSqlScript(updateQuery, INSERT_SQL_FILE_NAME);
        generateSqlScriptService.insertSqlScript(rollbackUpdateQuery, ROLLBACK_SQL_FILE_NAME);
        if (activeDB) {
            authentMeansRepository.save(authentMeansEntity);
        }
        return INSERT_SQL_FILE_NAME;
    }

    @Override
    public String saveAuthentMean(AuthentMeansDTO authentMeansDTO) {

        AuthentMeansEntity authentMeansEntity = mappingAuthentMean.convertToEntity(authentMeansDTO, AuthentMeansEntity.class);

        Long lastId = authentMeansRepository.getMaxId();

        String insertQuery = String.format("INSERT INTO `authentmeans` (createdBy, creationDate, description, lastUpdateBy, " +
                        "lastUpdateDate, name, updateState) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                authentMeansEntity.getCreatedBy(),
                authentMeansEntity.getCreationDate(),
                authentMeansEntity.getDescription(),
                authentMeansEntity.getLastUpdateBy(),
                authentMeansEntity.getLastUpdateDate(),
                authentMeansEntity.getName(),
                authentMeansEntity.getUpdateState());

        String deleteQuery = "DELETE FROM `authentmeans` WHERE id ='" + lastId + "';";

        generateSqlScriptService.insertSqlScript(insertQuery, INSERT_SQL_FILE_NAME);
        generateSqlScriptService.insertSqlScript(deleteQuery, ROLLBACK_SQL_FILE_NAME);

        if (activeDB) {
            authentMeansRepository.save(authentMeansEntity);
        }
        return INSERT_SQL_FILE_NAME;
    }

    public Resource getDownloadFile(String FILE_NAME) {
        String FILE_PATH = "src/main/resources/sql_scripts/";
        return downloadFileService.downloadFile(FILE_NAME, FILE_PATH);
    }
}
