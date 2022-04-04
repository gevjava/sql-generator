package com.energizeglobal.sqlgenerator.dto;

public class SubIssuerDto {

    String acsId;
    Integer authenticationTimeOut;
    String defaultLanguage;
    String code;
    String codeSvi;
    String currencyCode;
    String name;
    String authentMeans;
    String label;
    Boolean personnalDataStorage;

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

    public Boolean getPersonnalDataStorage() {
        return personnalDataStorage;
    }

    public void setPersonnalDataStorage(Boolean personnalDataStorage) {
        this.personnalDataStorage = personnalDataStorage;
    }

    @Override
    public String toString() {
        return "SubIssuerDto{" +
                "acsId='" + acsId + '\'' +
                ", authenticationTimeOut=" + authenticationTimeOut +
                ", defaultLanguage='" + defaultLanguage + '\'' +
                ", code='" + code + '\'' +
                ", codeSvi='" + codeSvi + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", name='" + name + '\'' +
                ", authentMeans='" + authentMeans + '\'' +
                ", label='" + label + '\'' +
                ", personnalDataStorage=" + personnalDataStorage +
                '}';
    }
}
