import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DeleteService {

  constructor(private http:HttpClient) { }

  deleteSubissuer(id:any){
    return this.http.delete("/subissuer/"+id+"/delete");
  }
}
