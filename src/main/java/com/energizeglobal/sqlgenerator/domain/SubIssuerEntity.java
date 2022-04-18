package com.energizeglobal.sqlgenerator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subissuer")
public class SubIssuerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "authentMeans")
    private String authentMeans;

    @ManyToOne
    @JoinColumn(name = "fk_id_issuer", referencedColumnName = "id")
    private IssuerEntity issuer;

    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "subIssuers")
    @JsonIgnore
    private List<BinRangeEntity> bins;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_cryptoConfig", referencedColumnName = "id")
    @JsonIgnore
    private CryptoConfigurationEntity cryptoConfigEntity;

//    @ManyToMany(mappedBy = "subIssuers")
//    private List<NetworkEntity> networks;
//
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subIssuer")
    @JsonIgnore
    private List<Profile> profile;
//
//    @OneToMany(mappedBy = "subIssuer")
//    @JsonIgnore
//    private List<CustomItemSetEntity> customItemSets;
//
//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "subIssuer")
//    @JsonBackReference(value="MerchantPivotList")
//    private List<MerchantPivotListEntity> merchantPivotList;

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

    @Column(columnDefinition = "BIT", length = 1)
    private boolean resetChoicesIfSuccess;

    @Column(columnDefinition = "BIT", length = 1)
    private boolean manageBackupsCombinedAmounts;

    @Column(columnDefinition = "BIT", length = 1)
    private boolean manageChoicesCombinedAmounts;

    @Column(columnDefinition = "BIT", length = 1)
    private boolean hubMaintenanceModeEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAuthentMeans() {
        return authentMeans;
    }

    public void setAuthentMeans(String authentMeans) {
        this.authentMeans = authentMeans;
    }

    public IssuerEntity getIssuer() {
        return issuer;
    }

    public void setIssuer(IssuerEntity issuer) {
        this.issuer = issuer;
    }

    public CryptoConfigurationEntity getCryptoConfigEntity() {
        return cryptoConfigEntity;
    }

    public void setCryptoConfigEntity(CryptoConfigurationEntity cryptoConfigEntity) {
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

    public boolean isResetBackupsIfSuccess() {
        return resetBackupsIfSuccess;
    }

    public void setResetBackupsIfSuccess(boolean resetBackupsIfSuccess) {
        this.resetBackupsIfSuccess = resetBackupsIfSuccess;
    }

    public Boolean getPersonnalDataStorage() {
        return personnalDataStorage;
    }

    public void setPersonnalDataStorage(Boolean personnalDataStorage) {
        this.personnalDataStorage = personnalDataStorage;
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