package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SubIssuerRepository extends JpaRepository<SubIssuer, Long> {


    SubIssuer findByCode(String code);

    @Transactional
    void deleteByCode(String code);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE SubIssuer s SET s.acsId = :acsId, " +
            "s.authenticationTimeOut = :authenticationTimeOut," +
            "s.defaultLanguage = :defaultLanguage, " +
            "s.codeSvi = :codeSvi, " +
            "s.currencyCode = :currencyCode," +
            "s.name =:name, " +
            "s.label = :label, " +
            "s.authentMeans = :authentMeans," +
            "s.personnalDataStorage = :personnalDataStorage , " +
            "s.resetBackupsIfSuccess = :resetBackupsIfSuccess, " +
//            "s.resetChoicesIfSuccess = :resetChoicesIfSuccess, " +
//            "s.manageBackupsCombinedAmounts = :manageBackupsCombinedAmounts, " +
//            "s.manageChoicesCombinedAmounts = :manageChoicesCombinedAmounts, " +
            "s.hubMaintenanceModeEnabled = :hubMaintenanceModeEnabled " +
            "WHERE s.code = :subissuerCode")
    int updateSubIssuer(@Param("subissuerCode") String subissuerCode,
                        @Param("acsId") String acsId,
                        @Param("authenticationTimeOut") Integer authenticationTimeOut,
                        @Param("defaultLanguage") String defaultLanguage,
                        @Param("codeSvi") String codeSvi,
                        @Param("currencyCode") String currencyCode,
                        @Param("name") String name,
                        @Param("label") String label,
                        @Param("authentMeans") String authentMeans,
                        @Param("personnalDataStorage") Boolean personnalDataStorage,
                        @Param("resetBackupsIfSuccess") Boolean resetBackupsIfSuccess,
//                        @Param("resetChoicesIfSuccess") Boolean resetChoicesIfSuccess,
//                        @Param("manageBackupsCombinedAmounts") Boolean manageBackupsCombinedAmounts,
//                        @Param("manageChoicesCombinedAmounts") Boolean manageChoicesCombinedAmounts,
                        @Param("hubMaintenanceModeEnabled") Boolean hubMaintenanceModeEnabled);

}
