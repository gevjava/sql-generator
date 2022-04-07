package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.AuthentMeansEntity;
import com.energizeglobal.sqlgenerator.dto.AuthentMeansDTO;

import java.util.List;

public interface AuthentMeansService {

    List<AuthentMeansEntity> getAllAuthentMeans();

    AuthentMeansDTO getByIdAuthentMean(Long id);

    String deleteAuthentMeanById(Long id);

    String updateAuthentMean(AuthentMeansDTO authentMeansDTO);

    String saveAuthentMean(AuthentMeansDTO authentMeansDTO);
}
