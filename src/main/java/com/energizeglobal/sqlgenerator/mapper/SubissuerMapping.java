package com.energizeglobal.sqlgenerator.mapper;

import com.energizeglobal.sqlgenerator.domain.SubIssuerEntity;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDTO;

public class SubissuerMapping {

    public static SubIssuerEntity dtoToEntity(SubIssuerDTO subIssuerDto) {
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
        subIssuerEntity.setPersonnalDataStorage(subIssuerDto.isPersonnalDataStorage());
        subIssuerEntity.setResetBackupsIfSuccess(subIssuerDto.isResetBackupsIfSuccess());
        subIssuerEntity.setResetChoicesIfSuccess(subIssuerDto.isResetChoicesIfSuccess());
        subIssuerEntity.setManageBackupsCombinedAmounts(subIssuerDto.isManageBackupsCombinedAmounts());
        subIssuerEntity.setManageChoicesCombinedAmounts(subIssuerDto.isManageChoicesCombinedAmounts());
        subIssuerEntity.setHubMaintenanceModeEnabled(subIssuerDto.isHubMaintenanceModeEnabled());

        return subIssuerEntity;
    }


    public static SubIssuerDTO entityToDto(SubIssuerEntity subIssuerEntity) {
        SubIssuerDTO subIssuerDto = new SubIssuerDTO();
        subIssuerDto.setAcsId(subIssuerEntity.getAcsId());
        subIssuerDto.setAuthenticationTimeOut(subIssuerEntity.getAuthenticationTimeOut());
        subIssuerDto.setDefaultLanguage(subIssuerEntity.getDefaultLanguage());
        subIssuerDto.setCode(subIssuerEntity.getCode());
        subIssuerDto.setCodeSvi(subIssuerEntity.getCodeSvi());
        subIssuerDto.setCurrencyCode(subIssuerEntity.getCurrencyCode());
        subIssuerDto.setName(subIssuerEntity.getName());
        subIssuerDto.setLabel(subIssuerEntity.getLabel());
        subIssuerDto.setAuthentMeans(subIssuerEntity.getAuthentMeans());
        subIssuerDto.setPersonalDataStorage(subIssuerEntity.getPersonnalDataStorage());
        subIssuerDto.setResetBackupsIfSuccess(subIssuerEntity.isResetBackupsIfSuccess());
        subIssuerDto.setResetChoicesIfSuccess(subIssuerEntity.isResetChoicesIfSuccess());
        subIssuerDto.setManageBackupsCombinedAmounts(subIssuerEntity.isManageBackupsCombinedAmounts());
        subIssuerDto.setManageChoicesCombinedAmounts(subIssuerEntity.isManageChoicesCombinedAmounts());
        subIssuerDto.setHubMaintenanceModeEnabled(subIssuerEntity.isHubMaintenanceModeEnabled());

        return subIssuerDto;
    }
}
