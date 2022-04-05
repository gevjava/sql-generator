package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.domain.CryptoConfig;
import com.energizeglobal.sqlgenerator.dto.CryptoConfigDTO;
import com.energizeglobal.sqlgenerator.mapper.Mapping;
import com.energizeglobal.sqlgenerator.repository.CryptoConfigRepository;
import com.energizeglobal.sqlgenerator.service.CryptoConfigService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoConfigServiceImpl implements CryptoConfigService {

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

        List<CryptoConfig> cryptoConfigs = cryptoConfigRepository.findAll();

        return mappingCryptoConfig.mapList(cryptoConfigs, CryptoConfigDTO.class);
    }

    public CryptoConfigDTO getById(Long id) {

        CryptoConfig cryptoConfig = cryptoConfigRepository.getById(id);

        return mappingCryptoConfig.convertToDto(cryptoConfig, CryptoConfigDTO.class);
    }

    public String deleteById(Long id) {

        CryptoConfig cryptoConfig = cryptoConfigRepository.getById(id);

        String deleteQuery = "DELETE FROM `cryptoconfig` WHERE id ='" + id + "';";

        String rollbackQuery = "INSERT INTO `cryptoconfig` (`protocolOne`, `protocolTwo`, `description`)";
        String queryValue =
                " VALUES('"
                        + cryptoConfig.getProtocolOne()
                        + "', '"
                        + cryptoConfig.getProtocolTwo()
                        + "', '"
                        + cryptoConfig.getDescription()
                        + "')";

        generateSqlScriptService.insertSqlScript(deleteQuery);
        rollbackSqlScriptService.rollbackScript(rollbackQuery + queryValue);
        cryptoConfigRepository.deleteById(id);
        return INSERT_SQL_FILE_NAME;
    }

    public String saveCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

        CryptoConfig cryptoConfig = mappingCryptoConfig.convertToEntity(cryptoConfigDTO, CryptoConfig.class);

        String queryType = "INSERT INTO `cryptoconfig` (`protocolOne`, `protocolTwo`, `description`)";
        String queryValue =
                " VALUES('"
                        + cryptoConfig.getProtocolOne()
                        + "', '"
                        + cryptoConfig.getProtocolTwo()
                        + "', '"
                        + cryptoConfig.getDescription()
                        + "')";

        String deleteQuery = "DELETE FROM `cryptoconfig` WHERE id ='" + cryptoConfig.getId() + "';";

        generateSqlScriptService.insertSqlScript(queryType + queryValue);

        rollbackSqlScriptService.rollbackScript(deleteQuery);

        cryptoConfigRepository.save(cryptoConfig);

        return INSERT_SQL_FILE_NAME;
    }

    public String updateCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

        CryptoConfig rollbackCryptoConfig = cryptoConfigRepository.getById(cryptoConfigDTO.getId());
        CryptoConfig cryptoConfig = mappingCryptoConfig.convertToEntity(cryptoConfigDTO, CryptoConfig.class);

        String updateQuery =
                "update `cryptoconfig` set `protocolOne` = '"
                        + cryptoConfig.getProtocolOne()
                        + "',`protocolTwo` = '"
                        + cryptoConfig.getProtocolTwo()
                        + "', `description` = '"
                        + cryptoConfig.getDescription()
                        + "' WHERE id ='"
                        + cryptoConfig.getId()
                        + "'";

        String rollbackQuery =
                "update `cryptoconfig` set `protocolOne` = '"
                        + rollbackCryptoConfig.getProtocolOne()
                        + "',`protocolTwo` = '"
                        + rollbackCryptoConfig.getProtocolTwo()
                        + "', `description` = '"
                        + rollbackCryptoConfig.getDescription()
                        + "' WHERE id ='"
                        + rollbackCryptoConfig.getId()
                        + "'";

        generateSqlScriptService.insertSqlScript(updateQuery);

        rollbackSqlScriptService.rollbackScript(rollbackQuery);

        cryptoConfigRepository.save(cryptoConfig);

        return INSERT_SQL_FILE_NAME;
    }

    public Resource getDownloadFile(String FILE_NAME) {
        return downloadFileService.downloadFile(FILE_NAME, FILE_PATH);
    }
}
