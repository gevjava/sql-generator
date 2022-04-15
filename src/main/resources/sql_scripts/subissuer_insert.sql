USE u5g_acs_bo;

UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = 19550, currencyCode = 978, name = 'Landesbank Baden-Württemberg', label = 'LBW', authentMeans = '[ {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "UNDEFINED",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP_EXT",
  "validate" : true
}, {
  "authentMeans" : "PHOTO_TAN",
  "validate" : true
}, {
  "authentMeans" : "OTP_SMS_EXT_MESSAGE",
  "validate" : true
}, {
  "authentMeans" : "I_TAN",
  "validate" : true
}, {
  "authentMeans" : "EXT_PASSWORD",
  "validate" : true
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19550;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , name,  label , authentMeans , personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )  VALUES ('12343', 300, 'en', '1289', '87412', '98562', 's s', 'o', 'email', false, false, false, false, false, false);
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , name,  label , authentMeans , personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )  VALUES ('12343', 300, 'en', '1289', '87412', '98562', 's s', 'o', 'email', false, false, false, false, false, false);
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = 19550, currencyCode = 978, name = 'Landesbank Baden-Württemberg', label = 'Landesbank Baden-Württemberg', authentMeans = '[ {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "UNDEFINED",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP_EXT",
  "validate" : true
}, {
  "authentMeans" : "PHOTO_TAN",
  "validate" : true
}, {
  "authentMeans" : "OTP_SMS_EXT_MESSAGE",
  "validate" : true
}, {
  "authentMeans" : "I_TAN",
  "validate" : true
}, {
  "authentMeans" : "EXT_PASSWORD",
  "validate" : true
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19550;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19550;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19550;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19550;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = '19550', currencyCode = '978', name = 'Landesbank Baden-Württemberg', label = 'LBW', authentMeans = '[ {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "UNDEFINED",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP_EXT",
  "validate" : true
}, {
  "authentMeans" : "PHOTO_TAN",
  "validate" : true
}, {
  "authentMeans" : "OTP_SMS_EXT_MESSAGE",
  "validate" : true
}, {
  "authentMeans" : "I_TAN",
  "validate" : true
}, {
  "authentMeans" : "EXT_PASSWORD",
  "validate" : true
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = '19550', currencyCode = '978', name = 'Landesbank Baden-Württemberg', label = 'Landesbank Baden-Württemberg', authentMeans = '[ {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "UNDEFINED",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP_EXT",
  "validate" : true
}, {
  "authentMeans" : "PHOTO_TAN",
  "validate" : true
}, {
  "authentMeans" : "OTP_SMS_EXT_MESSAGE",
  "validate" : true
}, {
  "authentMeans" : "I_TAN",
  "validate" : true
}, {
  "authentMeans" : "EXT_PASSWORD",
  "validate" : true
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;
INSERT INTO subissuer  ( acsId, authenticationTimeOut, defaultLanguage, code, codeSvi, currencyCode, name, label, authentMeans, personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )
 VALUES ('12343', 200, 'en', '1289', '87412', '98562', 'Commerz Bank', 'LBW', 'email', false, false, false, false, false, false);
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = '19550', currencyCode = '978', name = 'Landesbank Baden-Württemberg', label = 'LBW', authentMeans = '[ {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "UNDEFINED",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP_EXT",
  "validate" : true
}, {
  "authentMeans" : "PHOTO_TAN",
  "validate" : true
}, {
  "authentMeans" : "OTP_SMS_EXT_MESSAGE",
  "validate" : true
}, {
  "authentMeans" : "I_TAN",
  "validate" : true
}, {
  "authentMeans" : "EXT_PASSWORD",
  "validate" : true
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;
INSERT INTO subissuer  ( acsId, authenticationTimeOut, defaultLanguage, code, codeSvi, currencyCode, name, label, authentMeans, personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )  VALUES ('1010', 300, 'en', '1252', '10101', '4141', 'BDG bank', 'BDG', 'sms', false, false, false, false, false, false);
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = '19550', currencyCode = '978', name = 'Landesbank Baden-Württemberg', label = 'LBW', authentMeans = '[ {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "UNDEFINED",
  "validate" : true
}, {
  "authentMeans" : "MOBILE_APP_EXT",
  "validate" : true
}, {
  "authentMeans" : "PHOTO_TAN",
  "validate" : true
}, {
  "authentMeans" : "OTP_SMS_EXT_MESSAGE",
  "validate" : true
}, {
  "authentMeans" : "I_TAN",
  "validate" : true
}, {
  "authentMeans" : "EXT_PASSWORD",
  "validate" : true
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19550;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;