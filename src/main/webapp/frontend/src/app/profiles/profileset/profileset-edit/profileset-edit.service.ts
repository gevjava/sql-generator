import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfilesetEditService {

  constructor(private http: HttpClient) { }

  
  getById(id: any){
    return this.http.get("/profilesets/" + id);
  }

  update(profileSetEditForm:any,id:any){
    console.log(JSON.stringify(profileSetEditForm.value.name) + "|" + id);
  }

}
