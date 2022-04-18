package com.energizeglobal.sqlgenerator.mapper;

import com.energizeglobal.sqlgenerator.domain.SubIssuerEntity;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;

public class SubissuerMapping {

    public static SubIssuerEntity dtoToEntity(SubIssuerDto subIssuerDto) {
        SubIssuerEntity subIssuerEntity = new SubIssuerEntity();
        subIssuerEntity.setAcsId(subIssuerDto.getAcsId());
        subIssuerEntity.setAuthenticationTimeOut(subIssuerDto.getAuthenticationTimeOut());
        subIssuerEntity.setDefaultLanguage(subIssuerDto.getDefaultLanguage());
        subIssuerEntity.setCode(subIssuerDto.getCode());
        subIssuerEntity.setCodeSvi(subIssuerDto.getCodeSvi());
        subIssuerEntity.setCurrencyCode(subIssuerDto.getCurrencyCode());
        subIssuerEntity.setName(subIssuerDto.getName());
        subIssuerEntity.setLabel(subIssuerDto.getLabel());
        subIssuerEntity.setAuthentMeans(subIssuerDto.getAuthentMeans());
        subIssuerEntity.setPersonnalDataStorage(subIssuerDto.getPersonnalDataStorage());
        subIssuerEntity.setResetBackupsIfSuccess(subIssuerDto.getResetBackupsIfSuccess());
        subIssuerEntity.setResetChoicesIfSuccess(subIssuerDto.getResetChoicesIfSuccess());
        subIssuerEntity.setManageBackupsCombinedAmounts(subIssuerDto.getManageBackupsCombinedAmounts());
        subIssuerEntity.setManageChoicesCombinedAmounts(subIssuerDto.getManageChoicesCombinedAmounts());
        subIssuerEntity.setHubMaintenanceModeEnabled(subIssuerDto.getHubMaintenanceModeEnabled());

        return subIssuerEntity;
    }


    public static SubIssuerDto entityToDto(SubIssuerEntity subIssuerEntity) {
        SubIssuerDto subIssuerDto = new SubIssuerDto();
        subIssuerDto.setAcsId(subIssuerEntity.getAcsId());
        subIssuerDto.setAuthenticationTimeOut(subIssuerEntity.getAuthenticationTimeOut());
        subIssuerDto.setDefaultLanguage(subIssuerEntity.getDefaultLanguage());
        subIssuerDto.setCode(subIssuerEntity.getCode());
        subIssuerDto.setCodeSvi(subIssuerEntity.getCodeSvi());
        subIssuerDto.setCurrencyCode(subIssuerEntity.getCurrencyCode());
        subIssuerDto.setName(subIssuerEntity.getName());
        subIssuerDto.setLabel(subIssuerEntity.getLabel());
        subIssuerDto.setAuthentMeans(subIssuerEntity.getAuthentMeans());
        subIssuerDto.setPersonnalDataStorage(subIssuerEntity.getPersonnalDataStorage());
        subIssuerDto.setResetBackupsIfSuccess(subIssuerEntity.isResetBackupsIfSuccess());
        subIssuerDto.setResetChoicesIfSuccess(subIssuerEntity.isResetChoicesIfSuccess());
        subIssuerDto.setManageBackupsCombinedAmounts(subIssuerEntity.isManageBackupsCombinedAmounts());
        subIssuerDto.setManageChoicesCombinedAmounts(subIssuerEntity.isManageChoicesCombinedAmounts());
        subIssuerDto.setHubMaintenanceModeEnabled(subIssuerEntity.isHubMaintenanceModeEnabled());

        return subIssuerDto;
    }
}
