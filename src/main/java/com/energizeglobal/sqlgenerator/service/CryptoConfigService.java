package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.dto.CryptoConfigDTO;

import java.util.List;

public interface CryptoConfigService {

    List<CryptoConfigDTO> findAllCryptoConfigs();

    CryptoConfigDTO getById(Long id);

    String deleteById(Long id);

    String saveCryptoConfig(CryptoConfigDTO cryptoConfigDTO);

    String updateCryptoConfig(CryptoConfigDTO cryptoConfigDTO);
}
