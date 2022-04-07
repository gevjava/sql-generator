package com.energizeglobal.sqlgenerator.domain;


import com.energizeglobal.sqlgenerator.enams.HubCallMode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "SubIssuer")
public class SubIssuerEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EntityData data;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String label;

    @Column
    private String codeSvi;

    @Column
    private String acsId;

    @Column
    private String defaultLanguage;

    @Column
    private String backupLanguages;

    @Column
    private Integer transactionTimeOut;

    @Column
    private Integer authenticationTimeOut;

    @Column
    private Integer freshnessPeriod;

    @Column
    private String currencyCode;

    @Column
    private String acs_URL1_VE_MC;

    @Column
    private String acs_URL2_VE_MC;

    @Column
    private String acs_URL1_VE_VISA;

    @Column
    private String acs_URL2_VE_VISA;

    @Column
    private String acs_URL1_VE_CB;

    @Column
    private String acs_URL2_VE_CB;

    @Column(columnDefinition = "BIT", length = 1)
    private Boolean personnalDataStorage;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean resetBackupsIfSuccess;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean resetChoicesIfSuccess;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean manageBackupsCombinedAmounts;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean manageChoicesCombinedAmounts;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean automaticDeviceSelection;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean userChoiceAllowed;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean backupAllowed;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean defaultDeviceChoice;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean displayLanguageSelectPage;

    @Column
    private String preferredAuthentMeans;

    @Column
    private String issuerCountry;

    @Column
    @Enumerated(EnumType.STRING)
    private HubCallMode hubCallMode;

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

    @Column(columnDefinition = "TEXT")
    private String authentMeans;

    @Column(name = "currencyFormat", columnDefinition = "text")
    private String currencyFormatConfig;

    @Column(name = "npaEnabled", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean npaEnabled;

    @Column(name = "hubMaintenanceModeEnabled", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean hubMaintenanceModeEnabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_cryptoConfig", referencedColumnName = "id")
    @JsonIgnore
    private CryptoConfigurationEntity cryptoConfigurationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_issuer", referencedColumnName = "id")
    private IssuerEntity issuer;

    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "subIssuers")
    @JsonIgnore
    private List<BinRangeEntity> bins;

//    @OneToMany(mappedBy = "subIssuer")
//    @JsonIgnore
//    private List<CustomItemSetEntity> customItemSets;
//
//  @ManyToMany(mappedBy = "subIssuers")
//  private List<NetworkEntity> networks;
//
//  @OneToMany(cascade = CascadeType.ALL, mappedBy = "subIssuer")
//  @JsonIgnore
//  private List<ProfileSetEntity> profileSets;
//
//
//  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "subIssuer")
//  @JsonBackReference(value="MerchantPivotList")
//  private List<MerchantPivotListEntity> merchantPivotList;
}
