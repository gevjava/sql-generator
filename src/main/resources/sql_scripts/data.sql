USE u5g_acs_bo;

UPDATE Issuer SET createdBy='A1693', creationDate='2018-06-07T10:20:42Z' ,name='China Bank Corporation', updateState='PUSHED_TO_CONFIG', label='China Bank Corporation' , availaibleAuthentMeans='OTP_SMS|REFUSAL' WHERE code='00070';
UPDATE Issuer SET createdBy='A169318', creationDate='2018-06-07T10:20:42Z' ,name='China Bank Corporation', updateState='PUSHED_TO_CONFIG', label='China Bank Corporation' , availaibleAuthentMeans='OTP_SMS|REFUSAL' WHERE code='00070';
INSERT INTO subissuer  ( acsId, authenticationTimeOut, defaultLanguage, code, codeSvi, currencyCode, name, label, authentMeans, personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )
 VALUES ('02356', 320, 'en', '2356', '4578', '21345', 'Commerz Bank Of  Armnenia', 'CBOA', 'email', false, true, false, true, false, true);
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
} ]', personnalDataStorage = true, resetBackupsIfSuccess = false, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = true  WHERE code = 19550;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19550;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;