package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.SubIssuerEntity;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDTO;
import com.energizeglobal.sqlgenerator.mapper.SubissuerMapping;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;

@Service
public class SubissuerRollbackService {

    String FILE_PATH = "src/main/resources/sql_scripts/";
    String ROLLBACK_FILE_NAME = "rollback_data.sql";
    String path = FILE_PATH + ROLLBACK_FILE_NAME;


    public String generateSqlScriptForDeleteRollback(SubIssuerDTO dto) {

        SubIssuerEntity subIssuerEntity = SubissuerMapping.dtoToEntity(dto);

        String queryType = "INSERT INTO subissuer  ( " +
                "acsId, " +
                "authenticationTimeOut, " +
                " defaultLanguage, " +
                "code, " +
                "codeSvi, " +
                "currencyCode, " +
                "name, " +
                "label, " +
                "authentMeans, " +
                "personnalDataStorage, " +
                "resetBackupsIfSuccess," +
                "resetChoicesIfSuccess, " +
                "manageBackupsCombinedAmounts, " +
                "manageChoicesCombinedAmounts, " +
                "hubMaintenanceModeEnabled )";

        String queryValue = "  VALUES ('" +
                subIssuerEntity.getAcsId() + "', " +
                subIssuerEntity.getAuthenticationTimeOut() + ", '" +
                subIssuerEntity.getDefaultLanguage() + "', '" +
                subIssuerEntity.getCode() + "', '" +
                subIssuerEntity.getCodeSvi() + "', '" +
                subIssuerEntity.getCurrencyCode() + "', '" +
                subIssuerEntity.getName() + "', '" +
                subIssuerEntity.getLabel() + "', '" +
                subIssuerEntity.getAuthentMeans() + "', " +
                subIssuerEntity.getPersonnalDataStorage() + ", " +
                subIssuerEntity.isResetBackupsIfSuccess() + ", " +
                subIssuerEntity.isResetChoicesIfSuccess() + ", " +
                subIssuerEntity.isManageBackupsCombinedAmounts() + ", " +
                subIssuerEntity.isManageChoicesCombinedAmounts() + ", " +
                subIssuerEntity.isHubMaintenanceModeEnabled() + ");";

        String sqlInsert = queryType + queryValue;

        pathGenerator(sqlInsert);

        return ROLLBACK_FILE_NAME;
    }

    public String generateSqlScriptForUpdateRollback(SubIssuerEntity oldSubIssuerEntity) {

        String queryUpdate = "UPDATE subissuer SET " +
                "acsId = '" + oldSubIssuerEntity.getAcsId() + "', " +
                "authenticationTimeOut = " + oldSubIssuerEntity.getAuthenticationTimeOut() + ", " +
                "defaultLanguage = '" + oldSubIssuerEntity.getDefaultLanguage() + "', " +
                "codeSvi = " + oldSubIssuerEntity.getCodeSvi() + ", " +
                "currencyCode = " + oldSubIssuerEntity.getCurrencyCode() + ", " +
                "name = '" + oldSubIssuerEntity.getName() + "', " +
                "label = '" + oldSubIssuerEntity.getLabel() + "', " +
                "authentMeans = '" + oldSubIssuerEntity.getAuthentMeans() + "', " +
                "personnalDataStorage = " + oldSubIssuerEntity.getPersonnalDataStorage() + ", " +
                "resetBackupsIfSuccess = " + oldSubIssuerEntity.isResetBackupsIfSuccess() + ", " +
                "resetChoicesIfSuccess = " + oldSubIssuerEntity.isResetChoicesIfSuccess() + ", " +
                "manageBackupsCombinedAmounts = " + oldSubIssuerEntity.isManageBackupsCombinedAmounts() + ", " +
                "manageChoicesCombinedAmounts = " + oldSubIssuerEntity.isManageChoicesCombinedAmounts() + ", " +
                "hubMaintenanceModeEnabled = " + oldSubIssuerEntity.isHubMaintenanceModeEnabled() + " " +
                " WHERE code = " + oldSubIssuerEntity.getCode() + ";";

        pathGenerator(queryUpdate);

        return ROLLBACK_FILE_NAME;
    }

    public String generateSqlScriptForInsertRollback(String code) {

        String deleteQuery = "\n" +
                "START TRANSACTION; \n" +
                "SET FOREIGN_KEY_CHECKS = 0; \n" +
                "DELETE FROM subissuer WHERE code = " + code + ";\n" +
                "SET FOREIGN_KEY_CHECKS = 1; \n" +
                "COMMIT;";

        pathGenerator(deleteQuery);

        return ROLLBACK_FILE_NAME;
    }

    private void pathGenerator(String sql) {
        Path newFilePath = Paths.get(path);
        try {
            if (Files.exists(newFilePath)) {
                sql = System.getProperty("line.separator") + sql;
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFilePath, UTF_8, APPEND)) {
                    bufferedWriter.write(sql);
                }
            } else {
                Path fileDirectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDirectory);
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFilePath, UTF_8)) {
                    bufferedWriter.write(sql);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
