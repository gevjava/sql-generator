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

  private final Mapping mapping;

  private final CryptoConfigRepository cryptoConfigRepository;

  private final GenerateSqlScriptServiceServiceImpl generateSqlScriptServiceImpl;

  private final DownloadFileServiceImpl downloadFileServiceImpl;

  private String FILE_PATH = "src/main/resources/sql_scripts/";
  private String FILE_NAME = "insert.sql";

  public CryptoConfigServiceImpl(
      CryptoConfigRepository cryptoConfigRepository,
      Mapping mapping,
      DownloadFileServiceImpl downloadFileServiceImpl,
      GenerateSqlScriptServiceServiceImpl generateSqlScriptServiceImpl) {
    this.cryptoConfigRepository = cryptoConfigRepository;
    this.mapping = mapping;
    this.generateSqlScriptServiceImpl = generateSqlScriptServiceImpl;
    this.downloadFileServiceImpl = downloadFileServiceImpl;
  }

  public List<CryptoConfigDTO> findAllCryptoConfigs() {

    List<CryptoConfig> cryptoConfigs = cryptoConfigRepository.findAll();

    return mapping.mapList(cryptoConfigs, CryptoConfigDTO.class);
  }

  public CryptoConfigDTO getById(Long id) {

    CryptoConfig cryptoConfig = cryptoConfigRepository.getById(id);

    return mapping.convertToDto(cryptoConfig);
  }

  public String deleteById(Long id) {

    String query = "DELETE FROM `cryptoconfig` WHERE id ='" + id + "';";
    generateSqlScriptServiceImpl.insertSqlScript(query);
    cryptoConfigRepository.deleteById(id);
    return FILE_NAME;
  }

  public String saveCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

    CryptoConfig cryptoConfig = mapping.convertToEntity(cryptoConfigDTO);

    String queryType = "INSERT INTO `cryptoconfig` (`protocolOne`, `protocolTwo`, `description`)";
    String queryValue =
        " VALUES('"
            + cryptoConfig.getProtocolOne()
            + "', '"
            + cryptoConfig.getProtocolTwo()
            + "', '"
            + cryptoConfig.getDescription()
            + "')";

    generateSqlScriptServiceImpl.insertSqlScript(queryType + queryValue);

    cryptoConfigRepository.save(cryptoConfig);

    return FILE_NAME;
  }

  public String updateCryptoConfig(CryptoConfigDTO cryptoConfigDTO) {

    CryptoConfig cryptoConfig = mapping.convertToEntity(cryptoConfigDTO);

    String query =
            "update `cryptoconfig` set `protocolOne` = '"
                    + cryptoConfig.getProtocolOne()
                    + "',`protocolTwo` = '"
                    + cryptoConfig.getProtocolTwo()
                    + "', `description` = '"
                    + cryptoConfig.getDescription()
                    + "' WHERE id ='"
                    + cryptoConfig.getId()
                    + "'";

    generateSqlScriptServiceImpl.insertSqlScript(query);

    cryptoConfigRepository.save(cryptoConfig);

    return FILE_NAME;
  }

  public Resource getDownloadFile(String FILE_NAME) {
    return downloadFileServiceImpl.downloadFile(FILE_NAME, FILE_PATH);
  }
}
