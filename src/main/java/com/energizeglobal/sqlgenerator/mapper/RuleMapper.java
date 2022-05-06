package com.energizeglobal.sqlgenerator.mapper;

import com.energizeglobal.sqlgenerator.domain.RuleEntity;
import com.energizeglobal.sqlgenerator.dto.RuleDTO;

public class RuleMapper {
    public static RuleEntity dtoToEntity(RuleDTO ruleDto) {
        RuleEntity ruleEntity = new RuleEntity();

        ruleEntity.setId(ruleDto.getId());
        ruleEntity.setName(ruleDto.getName());
        ruleEntity.setOrderRule(ruleDto.getOrderRule());
        ruleEntity.setDescription(ruleDto.getDescription());

        return ruleEntity;

    }

    public static RuleDTO entityToDto(RuleEntity ruleEntity) {
        RuleDTO ruleDto = new RuleDTO();

        ruleDto.setId(ruleEntity.getId());
        ruleDto.setName(ruleEntity.getName());
        ruleDto.setOrderRule(ruleEntity.getOrderRule());
        ruleDto.setDescription(ruleEntity.getDescription());

        return ruleDto;
    }
}
