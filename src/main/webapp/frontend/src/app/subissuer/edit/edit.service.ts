import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EditService {

  constructor(private http:HttpClient) { }


  edit(subissuer:any,id:any){
    return this.http.put('/subissuer/' +id+'/edit',subissuer,{responseType: 'text'});
  }
}
