package com.energizeglobal.sqlgenerator.mapper;

import com.energizeglobal.sqlgenerator.domain.CryptoConfig;
import com.energizeglobal.sqlgenerator.dto.CryptoConfigDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapping {

  final ModelMapper modelMapper;

  public Mapping(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public CryptoConfigDTO convertToDto(CryptoConfig cryptoConfig) {

    CryptoConfigDTO cryptoConfigDTO = modelMapper.map(cryptoConfig, CryptoConfigDTO.class);
    System.out.println(cryptoConfigDTO);

    return cryptoConfigDTO;
  }

  public CryptoConfig convertToEntity(CryptoConfigDTO cryptoConfigDTO) {

    return modelMapper.map(cryptoConfigDTO, CryptoConfig.class);
  }

  public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
    return source.stream()
        .map(element -> modelMapper.map(element, targetClass))
        .collect(Collectors.toList());
  }
}
