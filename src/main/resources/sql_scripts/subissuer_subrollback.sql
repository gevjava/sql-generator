USE `U5G_ACS_BO`;

INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )  VALUES ('ACS_U5G', 120, 'de', '19550', '19550', '978', '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', 'Landesbank Baden-Württemberg', 'Landesbank Baden-Württemberg', true, true, true, true, true, true);

INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )  VALUES ('ACS_U5G', 120, 'de', '19550', '19550', '978', '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', 'Landesbank Baden-Württemberg', 'Landesbank Baden-Württemberg', true, true, true, true, true, true);
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = 19550, currencyCode = 978, name = 'Landesbank Baden-Württemberg', label = 'Landesbank Baden-Württemberg', authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 500;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;