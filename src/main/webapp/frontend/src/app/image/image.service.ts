import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Image} from "./image";


@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http: HttpClient) {
  }

  getAllImage() {
    return this.http.get('/image');
  }

  sendData(imageData: Image) {
    return this.http.post('/image', imageData, {responseType: 'text'});
  }

  downloadSqlFile(filename: String) {
    return this.http.get('/image/script/download/' + filename, {responseType: 'blob'});
  }
}
