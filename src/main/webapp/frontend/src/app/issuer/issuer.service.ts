import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class IssuerService {

  constructor(private http: HttpClient) { }

  getAllIssuer(){
    return  this.http.get('/issuer');
  }

  sendIssuerData(issuerData:any){
    return this.http.post('/issuer', issuerData, { responseType: 'text'});
  }

  downloadFile(filename: String){
    return this.http.get('/issuer/script/download/'+filename, { responseType: 'blob'});
  }
}
