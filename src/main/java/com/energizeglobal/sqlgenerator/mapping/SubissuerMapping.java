package com.energizeglobal.sqlgenerator.mapping;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;

public class SubissuerMapping {

    public static SubIssuer dtoToEntity(SubIssuerDto subIssuerDto){
        SubIssuer subIssuer = new SubIssuer();
        subIssuer.setName(subIssuerDto.getName());
        subIssuer.setCode(subIssuerDto.getCode());
        subIssuer.setAuthentMeans(subIssuerDto.getAuthentMeans());

        return subIssuer;
    }

    public static SubIssuerDto entitytoDto(SubIssuer subIssuer){
        SubIssuerDto subIssuerDto = new SubIssuerDto();
        subIssuerDto.setName(subIssuer.getName());
        subIssuerDto.setCode(subIssuer.getCode());
        subIssuerDto.setAuthentMeans(subIssuer.getAuthentMeans());

        return subIssuerDto;
    }
}
