USE `U5G_ACS_BO`;


START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 18;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 18;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 18;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 18;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 18;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;


UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 300, defaultLanguage = 'en', code = 18, codeSvi = 18, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
} ]', name = 'RCBC Debit', label = 'RCBC Debit', personnalDataStorage = true, resetBackupsIfSuccess = true,
                     resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false,
                     hubMaintenanceModeEnabled = false  WHERE code = 18;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 18;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )  VALUES ('a', 0, 'p', 'l', 'k', 's', '[ {  "authentMeans" : "OTP_SMS",  "validate" : true}, {  "authentMeans" : "REFUSAL",  "validate" : true} ]', 'name', 'p', true, true, true, true, true, true);
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', code = 19450, codeSvi = 19450, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'Commerzbank Cobrands', label = 'Commerzbank Cobrands', personnalDataStorage = null, resetBackupsIfSuccess = true, resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', code = 19450, codeSvi = 19450, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'Commerzbank Cobrands', label = 'Commerzbank Cobrands', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', code = 19450, codeSvi = 19450, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'Commerzbank Cobrands', label = 'Commerzbank Cobrands', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', code = 19450, codeSvi = 194, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'Commerzbank Cobrands', label = 'Commerzbank Cobrands', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', code = 19600, codeSvi = 19600, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'Landesbank Berlin', label = 'Landesbank Berlin', personnalDataStorage = null, resetBackupsIfSuccess = true, resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false, hubMaintenanceModeEnabled = false  WHERE code = 19600;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 300, defaultLanguage = 'de', code = 16500, codeSvi = 16500, currencyCode = EUR, authentMeans = '[ {
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
} ]', name = 'ING', label = 'IN', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false, hubMaintenanceModeEnabled = false  WHERE code = 16500;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 300, defaultLanguage = 'de', code = 16500, codeSvi = 16500, currencyCode = EUR, authentMeans = '[ {
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
} ]', name = 'ING', label = 'IN', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = false, manageBackupsCombinedAmounts = false, manageChoicesCombinedAmounts = false, hubMaintenanceModeEnabled = false  WHERE code = 16500;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', code = 19450, codeSvi = 19450, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'Commerzbank Cobrands', label = 'Commerzbank Cobrands', personnalDataStorage = null, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', codeSvi = 19450, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'C', label = 'Commerzbank Cobrands', personnalDataStorage = null, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', codeSvi = 19450, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
}, {
  "authentMeans" : "INFO",
  "validate" : true
}, {
  "authentMeans" : "PWD_OTP",
  "validate" : true
}, {
  "authentMeans" : "PASSWORD",
  "validate" : true
} ]', name = 'Commerzbank Cobrands', label = 'Commerzbank Cobrands', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'hhhh', authenticationTimeOut = 2, defaultLanguage = 'hh', codeSvi = km,m,, currencyCode = mmm, authentMeans = 'gggg', name = 'jjj', label = 'f', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'hhhh', authenticationTimeOut = 2, defaultLanguage = 'hh', codeSvi = km,m,, currencyCode = mmm, authentMeans = 'f', name = 'gggg', label = 'jjj', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19450;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 300, defaultLanguage = 'en', codeSvi = 62, currencyCode = 978, authentMeans = '[ {
  "authentMeans" : "OTP_SMS",
  "validate" : true
}, {
  "authentMeans" : "REFUSAL",
  "validate" : true
} ]', name = 'East West Bank', label = 'East West Bank', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 62;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 300, defaultLanguage = 'en', codeSvi = 62, currencyCode = 978, authentMeans = '[ {  "authentMeans" : "OTP_SMS",  "validate" : true}, {  "authentMeans" : "REFUSAL",  "validate" : true} ]', name = 'East West Bank', label = 'East West Bank', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 62;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = 19600, currencyCode = 978, authentMeans = '[ {  "authentMeans" : "OTP_SMS",  "validate" : true}, {  "authentMeans" : "REFUSAL",  "validate" : true}, {  "authentMeans" : "PWD_OTP",  "validate" : true}, {  "authentMeans" : "PASSWORD",  "validate" : true} ]', name = 'Landesbank Berlin', label = 'Landesbank Berlin', personnalDataStorage = null, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19600;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 300, defaultLanguage = 'en', codeSvi = 62, currencyCode = 978, authentMeans = '[ {  "authentMeans" : "OTP_SMS",  "validate" : true}, {  "authentMeans" : "REFUSAL",  "validate" : true} ]', name = 'East West Bank', label = 'East West Bank', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 62;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 300, defaultLanguage = 'en', codeSvi = 62, currencyCode = 978, authentMeans = '[ {  "authentMeans" : "OTP_SMS",  "validate" : true}, {  "authentMeans" : "REFUSAL",  "validate" : true} ]', name = 'East West Bank', label = 'East West Bank', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 62;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 62;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19600;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;
UPDATE subissuer SET acsId = '00050', authenticationTimeOut = 300, defaultLanguage = 'am', codeSvi = 00440, currencyCode = 000440, authentMeans = 'SMS', name = 'Sahakyan Bank', label = 'Sahakyans', personnalDataStorage = false, resetBackupsIfSuccess = false, hubMaintenanceModeEnabled = false  WHERE code = null;
UPDATE subissuer SET acsId = '04568', authenticationTimeOut = 200, defaultLanguage = 'en', codeSvi = 00070, currencyCode = 0055, authentMeans = 'email', name = 'Arcax Bank', label = 'AB', personnalDataStorage = false, resetBackupsIfSuccess = false, hubMaintenanceModeEnabled = false  WHERE code = 00052000;
UPDATE subissuer SET acsId = 'hhhh', authenticationTimeOut = 2, defaultLanguage = 'hh', codeSvi = km,m,, currencyCode = mmm, authentMeans = 'jjj', name = 'f', label = 'gggg', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19450;
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess, hubMaintenanceModeEnabled )  VALUES ('052025', 0, 'en', '12546', '020202', '784501', 'SMS', 'VTB', 'VTB', false, false, false);
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess, hubMaintenanceModeEnabled )  VALUES ('052025', 0, 'en', '12546', '020202', '784501', 'SMS', 'VTB', 'VTB', false, false, true);
UPDATE subissuer SET acsId = 'acsid', authenticationTimeOut = 500, defaultLanguage = 'france', codeSvi = 784512, currencyCode = 45887, authentMeans = 'email', name = 'Evoca bank', label = 'EVOCA', personnalDataStorage = true, resetBackupsIfSuccess = true, hubMaintenanceModeEnabled = false  WHERE code = 19450;

START TRANSACTION; 
SET FOREIGN_KEY_CHECKS = 0; 
DELETE FROM subissuer WHERE code = 19450;
SET FOREIGN_KEY_CHECKS = 1; 
COMMIT;

INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess, hubMaintenanceModeEnabled )  VALUES ('784512', 0, 'en', '568974', '214879', '215487', 'sms', 'Orang Bank', 'Orang', false, false, false);
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess, hubMaintenanceModeEnabled )  VALUES ('36985', 300, 'fr', '45789', '235689', '45789', 'sms', 'Orang Bank', 'Orange', false, false, false);
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess, hubMaintenanceModeEnabled )  VALUES ('36985', 300, 'fr', '45789', '235689', '45789', 'sms', 'Orang Bank', 'Orange', false, false, false);
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess, hubMaintenanceModeEnabled )  VALUES ('36985', 300, 'fr', '45789', '235689', '45789', 'sms', 'Orang Bank', 'Orange', false, false, false);
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 120, defaultLanguage = 'de', codeSvi = 19550, currencyCode = 978, authentMeans = '[ {
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
} ]', name = 'Landesbank Baden-Württemberg', label = 'Landesbank Baden-Württemberg', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = false  WHERE code = 19550;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', codeSvi = 19440, currencyCode = 978, authentMeans = 'sms', name = 'Commerzbank AG', label = 'Commerzbank AG', personnalDataStorage = null, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = false  WHERE code = 19440;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', codeSvi = 19440, currencyCode = 978, authentMeans = 'sms', name = 'Commerzbank AG', label = 'Commerzbank AG', personnalDataStorage = null, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = false  WHERE code = 19440;
UPDATE subissuer SET acsId = 'ACS_U5G', authenticationTimeOut = 290, defaultLanguage = 'de', codeSvi = 19440, currencyCode = 978, authentMeans = 'sms', name = 'Commerzbank AG', label = 'Commerzbank AG', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = false  WHERE code = 19440;
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
} ]', personnalDataStorage = true, resetBackupsIfSuccess = true, resetChoicesIfSuccess = true, manageBackupsCombinedAmounts = true, manageChoicesCombinedAmounts = true, hubMaintenanceModeEnabled = false  WHERE code = 19550;
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
} ]', personnalDataStorage = true,
                     resetBackupsIfSuccess = true,
                     resetChoicesIfSuccess = true,
                     manageBackupsCombinedAmounts = true,
                     manageChoicesCombinedAmounts = true,
                     hubMaintenanceModeEnabled = true  WHERE code = 19550;
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess, hubMaintenanceModeEnabled )  VALUES ('n', 0, 'n', '458', '8797', '8745', 'n', 'n', 'n', true, false, false);
INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )
VALUES ('789845', 0, 'en', '78465', '747', '7477', 'sms', 'ASGBC BAnk', 'ASGBC', false, true, false, true, true, false);

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

INSERT INTO subissuer  ( acsId ,authenticationTimeOut, defaultLanguage , code, codeSvi ,currencyCode , authentMeans , name,  label , personnalDataStorage, resetBackupsIfSuccess,resetChoicesIfSuccess, manageBackupsCombinedAmounts, manageChoicesCombinedAmounts, hubMaintenanceModeEnabled )
 VALUES ('4245254', 0, 'en', '500', '7414', '74', 'sms', 'GBD', 'GBD', true, false, true, false, true, false);

