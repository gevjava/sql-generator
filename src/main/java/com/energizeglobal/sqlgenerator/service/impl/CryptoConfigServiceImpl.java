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

    private final Mapping mappingCryptoConfig;

    private final CryptoConfigRepository cryptoConfigRepository;

    private final GenerateSqlScriptServiceImpl generateSqlScriptService;

    private final RollbackSqlScriptServiceImpl rollbackSqlScriptService;

    private final DownloadFileServiceImpl downloadFileService;

    private String FILE_PATH = "src/main/resources/sql_scripts/";
    private String INSERT_SQL_FILE_NAME = "insert_query.sql";
    //private String ROLLBACK_SQL_FILE_NAME = "rollback_query.sql";

    public CryptoConfigServiceImpl(
            CryptoConfigRepository cryptoConfigRepository,
            Mapping mappingCryptoConfig,
            DownloadFileServiceImpl downloadFileService,
            GenerateSqlScriptServiceImpl generateSqlScriptService, RollbackSqlScriptServiceImpl rollbackSqlScriptService) {
        this.cryptoConfigRepository = cryptoConfigRepository;
        this.mappingCryptoConfig = mappingCryptoConfig;
        this.generateSqlScriptService = generateSqlScriptService;
        this.downloadFileService = downloadFileService;
        this.rollbackSqlScriptService = rollbackSqlScriptService;
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

        String rollbackQuery = "INSERT INTO `cryptoconfig` (`protocolOne`, `protocolTwo`, `description`)";
        String queryValue =
                " VALUES('"
                        + cryptoConfigurationEntity.getProtocolOne()
                        + "', '"
                        + cryptoConfigurationEntity.getProtocolTwo()
                        + "', '"
                        + cryptoConfigurationEntity.getDescription()
                        + "')";

        generateSqlScriptService.insertSqlScript(deleteQuery);
        rollbackSqlScriptService.rollbackScript(rollbackQuery + queryValue);
        if (activeDB)
        cryptoConfigRepository.deleteById(id);
        return INSERT_SQL_FILE_NAME;
    }

    public String saveCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

        CryptoConfigurationEntity cryptoConfigurationEntity = mappingCryptoConfig.convertToEntity(cryptoConfigDTO, CryptoConfigurationEntity.class);

        String queryType = String.format("INSERT INTO `cryptoconfig` (`protocolOne`, `protocolTwo`, `description`) VALUES('%s', '%s', '%s')",
                cryptoConfigurationEntity.getProtocolOne(),
                cryptoConfigurationEntity.getProtocolTwo(),
                cryptoConfigurationEntity.getDescription());


        cryptoConfigRepository.save(cryptoConfigurationEntity);

        generateSqlScriptService.insertSqlScript(queryType);

        Long lastId = cryptoConfigRepository.getMaxId();

        String deleteQuery = "DELETE FROM `cryptoconfig` WHERE id ='" + lastId + "';";

        if (activeDB)
        rollbackSqlScriptService.rollbackScript(deleteQuery);

        return INSERT_SQL_FILE_NAME;
    }

    public String updateCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

        CryptoConfigurationEntity rollbackCryptoConfigurationEntity = cryptoConfigRepository.getById(cryptoConfigDTO.getId());
        CryptoConfigurationEntity cryptoConfigurationEntity = mappingCryptoConfig.convertToEntity(cryptoConfigDTO, CryptoConfigurationEntity.class);

        String updateQuery =
                "update `cryptoconfig` set `protocolOne` = '"
                        + cryptoConfigurationEntity.getProtocolOne()
                        + "',`protocolTwo` = '"
                        + cryptoConfigurationEntity.getProtocolTwo()
                        + "', `description` = '"
                        + cryptoConfigurationEntity.getDescription()
                        + "' WHERE id ='"
                        + cryptoConfigurationEntity.getId()
                        + "'";

        String rollbackQuery =
                "update `cryptoconfig` set `protocolOne` = '"
                        + rollbackCryptoConfigurationEntity.getProtocolOne()
                        + "',`protocolTwo` = '"
                        + rollbackCryptoConfigurationEntity.getProtocolTwo()
                        + "', `description` = '"
                        + rollbackCryptoConfigurationEntity.getDescription()
                        + "' WHERE id ='"
                        + rollbackCryptoConfigurationEntity.getId()
                        + "'";

        generateSqlScriptService.insertSqlScript(updateQuery);

        rollbackSqlScriptService.rollbackScript(rollbackQuery);

        if(activeDB)
        cryptoConfigRepository.save(cryptoConfigurationEntity);

        return INSERT_SQL_FILE_NAME;
    }

    public Resource getDownloadFile(String FILE_NAME) {
        return downloadFileService.downloadFile(FILE_NAME, FILE_PATH);
    }
}
