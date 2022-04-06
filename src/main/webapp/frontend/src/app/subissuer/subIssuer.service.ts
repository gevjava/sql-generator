import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Subissuer} from "./subissuer";

@Injectable({
  providedIn: 'root'
})
export class SubIssuerService {

  constructor(private http: HttpClient) {
  }

  getAllSubIssuer(){
    return this.http.get('/subissuer');
  }

  sendData(subIssuerData: Subissuer) {
    return this.http.post('/subissuer', subIssuerData, {responseType: 'text'});
  }

  downloadSqlFile(filename: String) {
    return this.http.get('/subissuer/script/download/' + filename, {responseType: 'blob'});
  }

  add(subIssuer: Subissuer) {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      observe: 'response' as 'response'
    };

    return this.http.post(
      '/subissuer',
      JSON.stringify({ acsId: subIssuer.acsId ,
        authenticationTimeOut: subIssuer.authenticationTimeOut,
        defaultLanguage: subIssuer.defaultLanguage,
        code: subIssuer.code,
        codeSvi: subIssuer.codeSvi,
        currencyCode: subIssuer.currencyCode,
        name: subIssuer.name,
        authentMeans: subIssuer.authentMeans,
        personnalDataStorage: subIssuer.personnalDataStorage,
        resetBackupsIfSuccess: subIssuer.resetBackupsIfSuccess,
        label:subIssuer.label}),
      httpOptions
    );
  }

}

