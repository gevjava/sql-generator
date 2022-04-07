package com.energizeglobal.sqlgenerator.mapping;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;

public class SubissuerMapping {

    public static SubIssuer dtoToEntity(SubIssuerDto subIssuerDto) {
        SubIssuer subIssuer = new SubIssuer();
        subIssuer.setAcsId(subIssuerDto.getAcsId());
        subIssuer.setAuthenticationTimeOut(subIssuerDto.getAuthenticationTimeOut());
        subIssuer.setDefaultLanguage(subIssuerDto.getDefaultLanguage());
        subIssuer.setCode(subIssuerDto.getCode());
        subIssuer.setCodeSvi(subIssuerDto.getCodeSvi());
        subIssuer.setCurrencyCode(subIssuerDto.getCurrencyCode());
        subIssuer.setAuthentMeans(subIssuerDto.getAuthentMeans());
        subIssuer.setName(subIssuerDto.getName());
        subIssuer.setLabel(subIssuerDto.getLabel());
        subIssuer.setPersonnalDataStorage(subIssuerDto.getPersonnalDataStorage());
        subIssuer.setResetBackupsIfSuccess(subIssuerDto.getResetBackupsIfSuccess());
        subIssuer.setResetChoicesIfSuccess(subIssuerDto.getResetChoicesIfSuccess());
        subIssuer.setManageBackupsCombinedAmounts(subIssuerDto.getManageBackupsCombinedAmounts());
        subIssuer.setManageChoicesCombinedAmounts(subIssuerDto.getManageChoicesCombinedAmounts());
        subIssuer.setHubMaintenanceModeEnabled(subIssuerDto.getHubMaintenanceModeEnabled());

        return subIssuer;
    }


    public static SubIssuerDto entityToDto(SubIssuer subIssuer) {
        SubIssuerDto subIssuerDto = new SubIssuerDto();
        subIssuerDto.setAcsId(subIssuer.getAcsId());
        subIssuerDto.setAuthenticationTimeOut(subIssuer.getAuthenticationTimeOut());
        subIssuerDto.setDefaultLanguage(subIssuer.getDefaultLanguage());
        subIssuerDto.setCode(subIssuer.getCode());
        subIssuerDto.setCodeSvi(subIssuer.getCodeSvi());
        subIssuerDto.setCurrencyCode(subIssuer.getCurrencyCode());
        subIssuerDto.setName(subIssuer.getName());
        subIssuerDto.setAuthentMeans(subIssuer.getAuthentMeans());
        subIssuerDto.setLabel(subIssuer.getLabel());
        subIssuerDto.setPersonnalDataStorage(subIssuer.getPersonnalDataStorage());
        subIssuerDto.setResetBackupsIfSuccess(subIssuer.getResetBackupsIfSuccess());
        subIssuerDto.setResetChoicesIfSuccess(subIssuer.getResetChoicesIfSuccess());
        subIssuerDto.setManageBackupsCombinedAmounts(subIssuer.getManageBackupsCombinedAmounts());
        subIssuerDto.setManageChoicesCombinedAmounts(subIssuer.getManageChoicesCombinedAmounts());
        subIssuerDto.setHubMaintenanceModeEnabled(subIssuer.getHubMaintenanceModeEnabled());

        return subIssuerDto;
    }
}
