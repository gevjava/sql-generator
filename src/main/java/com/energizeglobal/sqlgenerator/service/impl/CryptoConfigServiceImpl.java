package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.domain.CryptoConfigurationEntity;
import com.energizeglobal.sqlgenerator.dto.CryptoConfigDTO;
import com.energizeglobal.sqlgenerator.mapper.Mapping;
import com.energizeglobal.sqlgenerator.repository.CryptoConfigRepository;
import com.energizeglobal.sqlgenerator.service.CryptoConfigService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoConfigServiceImpl implements CryptoConfigService {

    private static boolean activeDB = true;

    private final String INSERT_SQL_FILE_NAME = "insert_query.sql";

    private final String ROLLBACK_SQL_FILE_NAME = "rollback_query.sql";

    private final Mapping mappingCryptoConfig;

    private final CryptoConfigRepository cryptoConfigRepository;

    private final GenerateSqlScriptServiceImpl generateSqlScriptService;

    private final DownloadFileServiceImpl downloadFileService;

    public CryptoConfigServiceImpl(
            CryptoConfigRepository cryptoConfigRepository,
            Mapping mappingCryptoConfig,
            DownloadFileServiceImpl downloadFileService,
            GenerateSqlScriptServiceImpl generateSqlScriptService) {
        this.cryptoConfigRepository = cryptoConfigRepository;
        this.mappingCryptoConfig = mappingCryptoConfig;
        this.generateSqlScriptService = generateSqlScriptService;
        this.downloadFileService = downloadFileService;
    }

    public List<CryptoConfigDTO> findAllCryptoConfigs() {

        List<CryptoConfigurationEntity> cryptoConfigEntities = cryptoConfigRepository.findAll();

        return mappingCryptoConfig.mapList(cryptoConfigEntities, CryptoConfigDTO.class);
    }

    public CryptoConfigDTO getById(Long id) {

        CryptoConfigurationEntity cryptoConfigurationEntity = cryptoConfigRepository.getById(id);

        return mappingCryptoConfig.convertToDto(cryptoConfigurationEntity, CryptoConfigDTO.class);
    }

    public String deleteById(Long id) {

        CryptoConfigurationEntity cryptoConfigurationEntity = cryptoConfigRepository.getById(id);

        String deleteQuery = "DELETE FROM `cryptoconfig` WHERE id ='" + id + "';";

        String rollbackQuery = String.format("INSERT INTO `cryptoconfig` (`protocolOne`, `protocolTwo`, `description`) " +
                        "VALUES('%s', '%s', '%s');",
                cryptoConfigurationEntity.getProtocolOne(),
                cryptoConfigurationEntity.getProtocolTwo(),
                cryptoConfigurationEntity.getDescription());

        generateSqlScriptService.insertSqlScript(deleteQuery, INSERT_SQL_FILE_NAME);
        generateSqlScriptService.insertSqlScript(rollbackQuery, ROLLBACK_SQL_FILE_NAME);
        if (activeDB)
            cryptoConfigRepository.deleteById(id);
        return INSERT_SQL_FILE_NAME;
    }

    public String saveCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

        CryptoConfigurationEntity cryptoConfigurationEntity = mappingCryptoConfig.convertToEntity(cryptoConfigDTO, CryptoConfigurationEntity.class);

        String queryType = String.format("INSERT INTO `cryptoconfig` (`protocolOne`, `protocolTwo`, `description`) VALUES('%s', '%s', '%s');",
                cryptoConfigurationEntity.getProtocolOne(),
                cryptoConfigurationEntity.getProtocolTwo(),
                cryptoConfigurationEntity.getDescription());


        cryptoConfigRepository.save(cryptoConfigurationEntity);

        generateSqlScriptService.insertSqlScript(queryType, INSERT_SQL_FILE_NAME);

        Long lastId = cryptoConfigRepository.getMaxId();

        String deleteQuery = "DELETE FROM `cryptoconfig` WHERE id ='" + lastId + "';";

        if (activeDB)
            generateSqlScriptService.insertSqlScript(deleteQuery, ROLLBACK_SQL_FILE_NAME);

        return INSERT_SQL_FILE_NAME;
    }

    public String updateCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

        CryptoConfigurationEntity cryptoConfigurationEntity = mappingCryptoConfig.convertToEntity(cryptoConfigDTO, CryptoConfigurationEntity.class);
        CryptoConfigurationEntity rollbackCryptoConfigurationEntity = cryptoConfigRepository.getById(cryptoConfigDTO.getId());


        String updateQuery = String.format("UPDATE `cryptoconfig` SET `protocolOne` = '%s', `protocolTwo` = '%s', `description` = '%s' WHERE id = '%s';",
                cryptoConfigurationEntity.getProtocolOne(),
                cryptoConfigurationEntity.getProtocolTwo(),
                cryptoConfigurationEntity.getDescription(),
                cryptoConfigurationEntity.getId());

        String rollbackQuery = String.format("UPDATE `cryptoconfig` SET `protocolOne` = '%s', `protocolTwo` = '%s', `description` = '%s' WHERE id = '%s';",
                rollbackCryptoConfigurationEntity.getProtocolOne(),
                rollbackCryptoConfigurationEntity.getProtocolTwo(),
                rollbackCryptoConfigurationEntity.getDescription(),
                rollbackCryptoConfigurationEntity.getId());

        generateSqlScriptService.insertSqlScript(updateQuery, INSERT_SQL_FILE_NAME);

        generateSqlScriptService.insertSqlScript(rollbackQuery, ROLLBACK_SQL_FILE_NAME);

        if (activeDB)
            cryptoConfigRepository.save(cryptoConfigurationEntity);

        return INSERT_SQL_FILE_NAME;
    }

    public Resource getDownloadFile(String FILE_NAME) {
        String FILE_PATH = "src/main/resources/sql_scripts/";
        return downloadFileService.downloadFile(FILE_NAME, FILE_PATH);
    }
}
