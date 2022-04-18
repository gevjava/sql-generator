package com.energizeglobal.sqlgenerator.dto;

public class SubIssuerDTO {
    private String acsId;
    private Integer authenticationTimeOut;
    private String defaultLanguage;
    private String code;
    private String codeSvi;
    private String currencyCode;
    private String name;
    private String authentMeans;
    private String label;
    private boolean personalDataStorage;
    private boolean resetBackupsIfSuccess;
    private boolean resetChoicesIfSuccess;
    private boolean manageBackupsCombinedAmounts;
    private boolean manageChoicesCombinedAmounts;
    private boolean hubMaintenanceModeEnabled;

    public String getAcsId() {
        return acsId;
    }

    public void setAcsId(String acsId) {
        this.acsId = acsId;
    }

    public Integer getAuthenticationTimeOut() {
        return authenticationTimeOut;
    }

    public void setAuthenticationTimeOut(Integer authenticationTimeOut) {
        this.authenticationTimeOut = authenticationTimeOut;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeSvi() {
        return codeSvi;
    }

    public void setCodeSvi(String codeSvi) {
        this.codeSvi = codeSvi;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthentMeans() {
        return authentMeans;
    }

    public void setAuthentMeans(String authentMeans) {
        this.authentMeans = authentMeans;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isPersonalDataStorage() {
        return personalDataStorage;
    }

    public void setPersonalDataStorage(boolean personalDataStorage) {
        this.personalDataStorage = personalDataStorage;
    }

    public boolean isResetBackupsIfSuccess() {
        return resetBackupsIfSuccess;
    }

    public void setResetBackupsIfSuccess(boolean resetBackupsIfSuccess) {
        this.resetBackupsIfSuccess = resetBackupsIfSuccess;
    }

    public boolean isResetChoicesIfSuccess() {
        return resetChoicesIfSuccess;
    }

    public void setResetChoicesIfSuccess(boolean resetChoicesIfSuccess) {
        this.resetChoicesIfSuccess = resetChoicesIfSuccess;
    }

    public boolean isManageBackupsCombinedAmounts() {
        return manageBackupsCombinedAmounts;
    }

    public void setManageBackupsCombinedAmounts(boolean manageBackupsCombinedAmounts) {
        this.manageBackupsCombinedAmounts = manageBackupsCombinedAmounts;
    }

    public boolean isManageChoicesCombinedAmounts() {
        return manageChoicesCombinedAmounts;
    }

    public void setManageChoicesCombinedAmounts(boolean manageChoicesCombinedAmounts) {
        this.manageChoicesCombinedAmounts = manageChoicesCombinedAmounts;
    }

    public boolean isHubMaintenanceModeEnabled() {
        return hubMaintenanceModeEnabled;
    }

    public void setHubMaintenanceModeEnabled(boolean hubMaintenanceModeEnabled) {
        this.hubMaintenanceModeEnabled = hubMaintenanceModeEnabled;
    }
}