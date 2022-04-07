export interface Subissuer {

  acsId: string;
  authenticationTimeOut: number;
  defaultLanguage: string;
  code: string;
  codeSvi: string;
  currencyCode: string;
  authentMeans: string;
  name: string;
  label: string;
  personnalDataStorage: boolean;
  resetBackupsIfSuccess: boolean;
  resetChoicesIfSuccess: boolean;
  manageBackupsCombinedAmounts: boolean;
  manageChoicesCombinedAmounts: boolean;
  hubMaintenanceModeEnabled: boolean;
}

