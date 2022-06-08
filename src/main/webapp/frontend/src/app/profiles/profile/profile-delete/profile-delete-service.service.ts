import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProfileDeleteServiceService {

  constructor(private http: HttpClient) { }


}
