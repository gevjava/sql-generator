package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.AuthentMeans;
import com.energizeglobal.sqlgenerator.dto.AuthentMeansDTO;

import java.util.List;

public interface AuthentMeansService {

    List<AuthentMeansDTO> getAllAuthentMeans();

    AuthentMeansDTO getByIdAuthentMean(Long id);

    void deleteAuthentMeanById(Long id);

    void updateAuthentMean(AuthentMeansDTO authentMeansDTO);
}
