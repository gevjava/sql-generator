import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProfilesetService {

  constructor(private http: HttpClient) { }

  getAllProfileSets(){
    return this.http.get("/profilesets");
  }


}
