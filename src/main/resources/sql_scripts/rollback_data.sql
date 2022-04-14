USE u5g_acs_bo;

UPDATE Issuer SET createdBy='A169318', creationDate='2018-06-07T10:20:42Z' ,name='China Bank Corporation',
                  updateState='PUSHED_TO_CONFIG', label='China Bank Corporation' , availaibleAuthentMeans='OTP_SMS|REFUSAL'
  WHERE code='00070';
UPDATE Issuer SET createdBy='A169318', creationDate='2018-06-07T10:20:42Z' ,name='China Bank Corporation', updateState='PUSHED_TO_CONFIG', label='China Bank Corporation' , availaibleAuthentMeans='OTP_SMS|REFUSAL' WHERE code='00070';

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 2356;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;
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
INSERT INTO subissuer  ( acsId, authenticationTimeOut,  defaultLanguage, code, codeSvi, currencyCode, name, label, authentMeans, personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )  VALUES ('ACS_U5G', 120, 'de', '19550', '19550', '978', 'Landesbank Baden-Württemberg', 'LBW', '[ {
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
} ]', true, true, true, true, true, true);