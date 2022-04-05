package com.energizeglobal.sqlgenerator.service.impl;

import com.energizeglobal.sqlgenerator.domain.AuthentMeans;
import com.energizeglobal.sqlgenerator.dto.AuthentMeansDTO;
import com.energizeglobal.sqlgenerator.mapper.Mapping;
import com.energizeglobal.sqlgenerator.repository.AuthentMeansRepository;
import com.energizeglobal.sqlgenerator.service.AuthentMeansService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthentMeansServiceImpl implements AuthentMeansService {

    @Autowired
    private final Mapping mappingAuthentMean;
    @Autowired
    private final AuthentMeansRepository authentMeansRepository;
    @Autowired
    private final GenerateSqlScriptServiceImpl generateSqlScriptService;
    @Autowired
    private final RollbackSqlScriptServiceImpl rollbackSqlScriptService;
    @Autowired
    private final DownloadFileServiceImpl downloadFileService;

    public AuthentMeansServiceImpl(Mapping mappingCryptoConfig, AuthentMeansRepository authentMeansRepository,
                                   GenerateSqlScriptServiceImpl generateSqlScriptService,
                                   RollbackSqlScriptServiceImpl rollbackSqlScriptService,
                                   DownloadFileServiceImpl downloadFileService) {
        this.mappingAuthentMean = mappingCryptoConfig;
        this.authentMeansRepository = authentMeansRepository;
        this.generateSqlScriptService = generateSqlScriptService;
        this.rollbackSqlScriptService = rollbackSqlScriptService;
        this.downloadFileService = downloadFileService;
    }


    @Override
    public List<AuthentMeansDTO> getAllAuthentMeans() {

        List<AuthentMeans> authentMeansList = authentMeansRepository.findAll();

        return mappingAuthentMean.mapList(authentMeansList, AuthentMeansDTO.class);
    }

    @Override
    public AuthentMeansDTO getByIdAuthentMean(Long id) {

        AuthentMeans authentMeans = authentMeansRepository.getById(id);

        return mappingAuthentMean.convertToDto(authentMeans, AuthentMeansDTO.class);
    }

    @Override
    public void deleteAuthentMeanById(Long id) {

        authentMeansRepository.deleteById(id);
    }

    @Override
    public void updateAuthentMean(AuthentMeansDTO authentMeansDTO) {

        AuthentMeans authentMeans = mappingAuthentMean.convertToEntity(authentMeansDTO, AuthentMeans.class);
        authentMeansRepository.save(authentMeans);
    }
}
