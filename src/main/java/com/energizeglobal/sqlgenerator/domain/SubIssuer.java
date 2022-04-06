package com.energizeglobal.sqlgenerator.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "subissuer")
public class SubIssuer {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "authentMeans")
    private String authentMeans;

    @ManyToOne
    @JoinColumn(name = "fk_id_issuer", referencedColumnName = "id")
    private Issuer issuer;

    @ManyToOne
    @JoinColumn(name = "fk_id_cryptoConfig", referencedColumnName = "id")
    @JsonIgnore
    private CryptoConfig cryptoConfigEntity;

    @Column
    private String acsId;

    @Column
    private Integer authenticationTimeOut;

    @Column
    private String defaultLanguage;

    @Column
    private String codeSvi;

    @Column
    private String currencyCode;

    @Column(nullable = false)
    private String label;

    @Column(columnDefinition = "BIT", length = 1)
    private boolean resetBackupsIfSuccess;

    @Column(columnDefinition = "BIT", length = 1)
    private Boolean personnalDataStorage;

    public SubIssuer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAuthentMeans() {
        return authentMeans;
    }

    public void setAuthentMeans(String authentMeans) {
        this.authentMeans = authentMeans;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public CryptoConfig getCryptoConfigEntity() {
        return cryptoConfigEntity;
    }

    public void setCryptoConfigEntity(CryptoConfig cryptoConfigEntity) {
        this.cryptoConfigEntity = cryptoConfigEntity;
    }

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

    public boolean getResetBackupsIfSuccess() {
        return resetBackupsIfSuccess;
    }

    public void setResetBackupsIfSuccess(boolean resetBackupsIfSuccess) {
        this.resetBackupsIfSuccess = resetBackupsIfSuccess;
    }

    @Override
    public String toString() {
        return "SubIssuer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", authentMeans='" + authentMeans + '\'' +
                ", issuer=" + issuer +
                ", cryptoConfigEntity=" + cryptoConfigEntity +
                ", acsId='" + acsId + '\'' +
                ", authenticationTimeOut=" + authenticationTimeOut +
                ", defaultLanguage='" + defaultLanguage + '\'' +
                ", codeSvi='" + codeSvi + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", label='" + label + '\'' +
                ", personnalDataStorage=" + personnalDataStorage +
                '}';
    }
}



