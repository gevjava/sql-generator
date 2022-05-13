import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Rule} from "./rule";

@Injectable({
  providedIn: 'root'
})
export class RuleService {

  constructor(private http: HttpClient) { }

  getAllRules(){
    return this.http.get('/rule');
  }

  sendData(ruleData: Rule){
    return this.http.post('/rule', ruleData, {responseType: 'text'});
  }

  downloadSqlFile(filename: String) {
    return this.http.get('/rule/script/download/' + filename, {responseType: 'blob'});
  }
}
