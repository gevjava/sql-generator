package com.energizeglobal.sqlgenerator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "subissuer")
public class SubIssuer {

//`id` + , `acsId + `, `authenticationTimeOut + `,
// `backupLanguages + `, `code + `, `codeSvi + `,
// `currencyCode + `, `createdBy` + , `creationDate`,
// `description`, `lastUpdateBy`, `lastUpdateDate`,
// `name`, `updateState`, `defaultLanguage`,
// `freshnessPeriod`, `label`, `manageBackupsCombinedAmounts`,
// `manageChoicesCombinedAmounts`,
// `personnalDataStorage` - ???? ,
// `resetBackupsIfSuccess`,
// `resetChoicesIfSuccess`, `transactionTimeOut`, `fk_id_issuer`,
// `acs_URL1_VE_MC`, `acs_URL2_VE_MC`, `acs_URL1_VE_CB`,
// `acs_URL2_VE_CB`, `acs_URL1_VE_VISA`, `acs_URL2_VE_VISA`,
// `automaticDeviceSelection`, `userChoiceAllowed`, `backupAllowed`,
// `defaultDeviceChoice`, `preferredAuthentMeans`, `issuerCountry`,
// `hubCallMode`, `rbaThreshold`, `maskParams`,
// `dateFormat`, `formattedDateJavaFormat`, `twoStepCancellation`,
// `fk_id_cryptoConfig`, `paChallengePublicUrl`, `verifyCardStatus`,
// `3DS2AdditionalInfo`, `permanentStrongMeansCounter`, `resendOTPThreshold`,
// `resendSameOTP`, `combinedAuthenticationAllowed`, `protocol2FlowMode`,
// `displayLanguageSelectPage`, `trustedBeneficiariesAllowed`, `authentMeans`,
// `currencyFormat`, `npaEnabled`, `hubMaintenanceModeEnabled   57

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    String name;

    @Column(name = "code")
    String code;

    @Column(name = "authentMeans")
    String authentMeans;

    @ManyToOne
    @JoinColumn(name = "fk_id_issuer", referencedColumnName = "id")
    private Issuer issuer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_cryptoConfig", referencedColumnName = "id")
    @JsonIgnore
    private CryptoConfig cryptoConfigEntity;

    @Column
    private String acsId ;

    @Column
    private Integer authenticationTimeOut;

    @Column
    private String defaultLanguage ;

    @Column
    private String codeSvi ;

    @Column
    private String currencyCode ;

    @Column
    private String createdBy ;


    @Column(nullable = false)
    private String label ;





















// TODO
    @Column(columnDefinition = "BIT", length = 1)
    private Boolean personnalDataStorage ;

    @Column
    private String backupLanguages = "backupLanguages";

    @Column
    private Integer transactionTimeOut = 123;

    @Column
    private Integer freshnessPeriod = 789;


    @Column
    private String acs_URL1_VE_MC = "acs_URL1_VE_MC";

    @Column
    private String acs_URL2_VE_MC = "acs_URL2_VE_MC";

    @Column
    private String acs_URL1_VE_VISA = "acs_URL1_VE_VISA";

    @Column
    private String acs_URL2_VE_VISA = "acs_URL2_VE_VISA";

    @Column
    private String acs_URL1_VE_CB = "acs_URL1_VE_CB";

    @Column
    private String acs_URL2_VE_CB = "acs_URL2_VE_CB";



    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean resetBackupsIfSuccess = false;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean resetChoicesIfSuccess = true;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean manageBackupsCombinedAmounts = false;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean manageChoicesCombinedAmounts = true;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean automaticDeviceSelection = false;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean userChoiceAllowed = true;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean backupAllowed = false;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean defaultDeviceChoice = true;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean displayLanguageSelectPage = false;

    @Column
    private String preferredAuthentMeans;

    @Column
    private String issuerCountry;


    @Column
    private Integer rbaThreshold;

    @Column
    private String maskParams;

    @Column
    private String dateFormat;

    @Column(nullable = false)
    private String formattedDateJavaFormat;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean twoStepCancellation;


    @Column(columnDefinition = "text")
    private String paChallengePublicUrl;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean verifyCardStatus;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private Boolean permanentStrongMeansCounter;

    @Column(name = "3DS2AdditionalInfo", columnDefinition = "text")
    private String operator;

    @Column
    private Integer resendOTPThreshold;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean resendSameOTP;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean combinedAuthenticationAllowed;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean trustedBeneficiariesAllowed;

    @Column(name = "currencyFormat", columnDefinition = "text")
    private String currencyFormatConfig;

    @Column(name = "npaEnabled", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean npaEnabled;

    @Column(name = "hubMaintenanceModeEnabled", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean hubMaintenanceModeEnabled;


//
//    @Column(nullable = false)
//    private String code; + 1
//
//    @Column(nullable = false)
//    private String label; + 2
//
//    @Column
//    private String codeSvi; + 3
//
//    @Column
//    private String acsId; + 4
//
//    @Column
//    private String defaultLanguage; + 5
//
//    @Column
//    private String backupLanguages; 6
//
//    @Column
//    private Integer transactionTimeOut;7
//
//    @Column
//    private Integer authenticationTimeOut; +8
//
//    @Column
//    private Integer freshnessPeriod;9
//
//    @Column
//    private String currencyCode;10
//
//    @Column
//    private String acs_URL1_VE_MC;11
//
//    @Column
//    private String acs_URL2_VE_MC;12
//
//    @Column
//    private String acs_URL1_VE_VISA;13
//
//    @Column
//    private String acs_URL2_VE_VISA;14
//
//    @Column
//    private String acs_URL1_VE_CB;15
//
//    @Column
//    private String acs_URL2_VE_CB;16
//
//    @Column(columnDefinition = "BIT", length = 1)
//    private Boolean personnalDataStorage;17
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean resetBackupsIfSuccess;18
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean resetChoicesIfSuccess;19
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean manageBackupsCombinedAmounts;20
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean manageChoicesCombinedAmounts;21
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean automaticDeviceSelection;22
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean userChoiceAllowed;23
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean backupAllowed;24
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean defaultDeviceChoice;25
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean displayLanguageSelectPage;26
//
//    @Column
//    private String preferredAuthentMeans;26
//
//    @Column
//    private String issuerCountry;28
//
//
//    @Column
//    private Integer rbaThreshold;29
//
//    @Column
//    private String maskParams;30
//
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean twoStepCancellation;31
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_id_cryptoConfig", referencedColumnName = "id")
//    @JsonIgnore
//    private CryptoConfigurationEntity cryptoConfigurationEntity; +32
//
//    @Column(columnDefinition = "text")
//    private String paChallengePublicUrl;
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)33
//    private boolean verifyCardStatus;
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)34
//    private Boolean permanentStrongMeansCounter;
//
//    @Column(name = "3DS2AdditionalInfo" , columnDefinition = "text")35
//    private String operator;
//
//    @Column
//    private Integer resendOTPThreshold;36
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean resendSameOTP;37
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean combinedAuthenticationAllowed;38
//
//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean trustedBeneficiariesAllowed;39
//
//    @Column(columnDefinition = "TEXT")
//    private String authentMeans;40
//
//    @Column(name = "currencyFormat", columnDefinition = "text")
//    private String currencyFormatConfig;41
//
//    @Column(name = "npaEnabled", nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean npaEnabled;42
//
//    @Column(name = "hubMaintenanceModeEnabled", nullable = false, columnDefinition = "BIT", length = 1)
//    private boolean hubMaintenanceModeEnabled;43
//
//    //    @Column
////    @Enumerated(EnumType.STRING)
////    private HubCallMode hubCallMode;
//
//    //    /**
////     * @see com.worldline.acs.config.issuers.IssuerConfig for more detail on format and usage
////     */
////    @Column
////    private String dateFormat;
////
////    /**
////     * @see com.worldline.acs.config.issuers.IssuerConfig for more detail on format and usage
////     */
////    @Column(nullable = false)
////    private String formattedDateJavaFormat;


    public SubIssuer() {
    }

    public String getAcsId() {
        return acsId;
    }

    public void setAcsId(String acsId) {
        this.acsId = acsId;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getFormattedDateJavaFormat() {
        return formattedDateJavaFormat;
    }

    public void setFormattedDateJavaFormat(String formattedDateJavaFormat) {
        this.formattedDateJavaFormat = formattedDateJavaFormat;
    }

    public boolean getTwoStepCancellation() {
        return twoStepCancellation;
    }

    public void setTwoStepCancellation(boolean twoStepCancellation) {
        this.twoStepCancellation = twoStepCancellation;
    }

    public String getPaChallengePublicUrl() {
        return paChallengePublicUrl;
    }

    public void setPaChallengePublicUrl(String paChallengePublicUrl) {
        this.paChallengePublicUrl = paChallengePublicUrl;
    }

    public boolean getVerifyCardStatus() {
        return verifyCardStatus;
    }

    public void setVerifyCardStatus(boolean verifyCardStatus) {
        this.verifyCardStatus = verifyCardStatus;
    }

    public Boolean isPermanentStrongMeansCounter() {
        return permanentStrongMeansCounter;
    }

    public void setPermanentStrongMeansCounter(Boolean permanentStrongMeansCounter) {
        this.permanentStrongMeansCounter = permanentStrongMeansCounter;
    }

    public Integer getResendOTPThreshold() {
        return resendOTPThreshold;
    }

    public void setResendOTPThreshold(Integer resendOTPThreshold) {
        this.resendOTPThreshold = resendOTPThreshold;
    }

    public boolean isResendSameOTP() {
        return resendSameOTP;
    }

    public void setResendSameOTP(boolean resendSameOTP) {
        this.resendSameOTP = resendSameOTP;
    }

    public boolean isCombinedAuthenticationAllowed() {
        return combinedAuthenticationAllowed;
    }

    public void setCombinedAuthenticationAllowed(boolean combinedAuthenticationAllowed) {
        this.combinedAuthenticationAllowed = combinedAuthenticationAllowed;
    }

    public boolean isDisplayLanguageSelectPage() {
        return displayLanguageSelectPage;
    }

    public void setDisplayLanguageSelectPage(boolean displayLanguageSelectPage) {
        this.displayLanguageSelectPage = displayLanguageSelectPage;
    }

    public boolean isTrustedBeneficiariesAllowed() {
        return trustedBeneficiariesAllowed;
    }

    public void setTrustedBeneficiariesAllowed(boolean trustedBeneficiariesAllowed) {
        this.trustedBeneficiariesAllowed = trustedBeneficiariesAllowed;
    }

    public String getCurrencyFormatConfig() {
        return currencyFormatConfig;
    }

    public void setCurrencyFormatConfig(String currencyFormatConfig) {
        this.currencyFormatConfig = currencyFormatConfig;
    }

    public boolean isNpaEnabled() {
        return npaEnabled;
    }

    public void setNpaEnabled(boolean npaEnabled) {
        this.npaEnabled = npaEnabled;
    }

    public boolean isHubMaintenanceModeEnabled() {
        return hubMaintenanceModeEnabled;
    }

    public void setHubMaintenanceModeEnabled(boolean hubMaintenanceModeEnabled) {
        this.hubMaintenanceModeEnabled = hubMaintenanceModeEnabled;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }


    public CryptoConfig getCryptoConfigEntity() {
        return cryptoConfigEntity;
    }

    public void setCryptoConfigEntity(CryptoConfig cryptoConfigEntity) {
        this.cryptoConfigEntity = cryptoConfigEntity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCodeSvi() {
        return codeSvi;
    }

    public void setCodeSvi(String codeSvi) {
        this.codeSvi = codeSvi;
    }



    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getBackupLanguages() {
        return backupLanguages;
    }

    public void setBackupLanguages(String backupLanguages) {
        this.backupLanguages = backupLanguages;
    }

    public Integer getTransactionTimeOut() {
        return transactionTimeOut;
    }

    public void setTransactionTimeOut(Integer transactionTimeOut) {
        this.transactionTimeOut = transactionTimeOut;
    }

    public Integer getAuthenticationTimeOut() {
        return authenticationTimeOut;
    }

    public void setAuthenticationTimeOut(Integer authenticationTimeOut) {
        this.authenticationTimeOut = authenticationTimeOut;
    }

    public Integer getFreshnessPeriod() {
        return freshnessPeriod;
    }

    public void setFreshnessPeriod(Integer freshnessPeriod) {
        this.freshnessPeriod = freshnessPeriod;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAcs_URL1_VE_MC() {
        return acs_URL1_VE_MC;
    }

    public void setAcs_URL1_VE_MC(String acs_URL1_VE_MC) {
        this.acs_URL1_VE_MC = acs_URL1_VE_MC;
    }

    public String getAcs_URL2_VE_MC() {
        return acs_URL2_VE_MC;
    }

    public void setAcs_URL2_VE_MC(String acs_URL2_VE_MC) {
        this.acs_URL2_VE_MC = acs_URL2_VE_MC;
    }

    public String getAcs_URL1_VE_VISA() {
        return acs_URL1_VE_VISA;
    }

    public void setAcs_URL1_VE_VISA(String acs_URL1_VE_VISA) {
        this.acs_URL1_VE_VISA = acs_URL1_VE_VISA;
    }

    public String getAcs_URL2_VE_VISA() {
        return acs_URL2_VE_VISA;
    }

    public void setAcs_URL2_VE_VISA(String acs_URL2_VE_VISA) {
        this.acs_URL2_VE_VISA = acs_URL2_VE_VISA;
    }

    public String getAcs_URL1_VE_CB() {
        return acs_URL1_VE_CB;
    }

    public void setAcs_URL1_VE_CB(String acs_URL1_VE_CB) {
        this.acs_URL1_VE_CB = acs_URL1_VE_CB;
    }

    public String getAcs_URL2_VE_CB() {
        return acs_URL2_VE_CB;
    }

    public void setAcs_URL2_VE_CB(String acs_URL2_VE_CB) {
        this.acs_URL2_VE_CB = acs_URL2_VE_CB;
    }

    public Boolean getPersonnalDataStorage() {
        return personnalDataStorage;
    }

    public void setPersonnalDataStorage(Boolean personnalDataStorage) {
        this.personnalDataStorage = personnalDataStorage;
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

    public boolean isAutomaticDeviceSelection() {
        return automaticDeviceSelection;
    }

    public void setAutomaticDeviceSelection(boolean automaticDeviceSelection) {
        this.automaticDeviceSelection = automaticDeviceSelection;
    }

    public boolean isUserChoiceAllowed() {
        return userChoiceAllowed;
    }

    public void setUserChoiceAllowed(boolean userChoiceAllowed) {
        this.userChoiceAllowed = userChoiceAllowed;
    }

    public boolean isBackupAllowed() {
        return backupAllowed;
    }

    public void setBackupAllowed(boolean backupAllowed) {
        this.backupAllowed = backupAllowed;
    }

    public boolean isDefaultDeviceChoice() {
        return defaultDeviceChoice;
    }

    public void setDefaultDeviceChoice(boolean defaultDeviceChoice) {
        this.defaultDeviceChoice = defaultDeviceChoice;
    }

    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }

    public String getPreferredAuthentMeans() {
        return preferredAuthentMeans;
    }

    public void setPreferredAuthentMeans(String preferredAuthentMeans) {
        this.preferredAuthentMeans = preferredAuthentMeans;
    }


    public boolean isManageChoicesCombinedAmounts() {
        return manageChoicesCombinedAmounts;
    }

    public void setManageChoicesCombinedAmounts(boolean manageChoicesCombinedAmounts) {
        this.manageChoicesCombinedAmounts = manageChoicesCombinedAmounts;
    }


    public Integer getRbaThreshold() {
        return rbaThreshold;
    }

    public void setRbaThreshold(Integer rbaThreshold) {
        this.rbaThreshold = rbaThreshold;
    }

    public String getMaskParams() {
        return maskParams;
    }

    public void setMaskParams(String maskParams) {
        this.maskParams = maskParams;
    }

    public boolean isTwoStepCancellation() {
        return twoStepCancellation;
    }

    public boolean isVerifyCardStatus() {
        return verifyCardStatus;
    }

    public Boolean getPermanentStrongMeansCounter() {
        return permanentStrongMeansCounter;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}



