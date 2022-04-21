import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from "file-saver";
import {DeleteimageserviceService} from "./deleteimageservice.service";

@Component({
  selector: 'app-imagedelete',
  templateUrl: './delete-image.component.html',
  styleUrls: ['./delete-image.component.css']
})
export class DeleteImageComponent implements OnInit {

  id: any;
  image: any;
  filename: string = "";
 imageForm: any;

  constructor(
    private service: DeleteimageserviceService,
    private router: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.id = this.router.snapshot.paramMap.get("code");
    this.initializeForm();
    this.getByCode(this.id);
  }

  deleteImage() {
    console.log(this.imageForm);
    let subIssuerData = this.imageForm.value;
    this.service.deleteImageService(subIssuerData, this.id).subscribe(response => {
      this.filename = response;
    });
  }

  downloadFile() {
    this.service.downloadSqlFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }


  getByCode(id: any) {
    this.service.getImageById(id).subscribe(resposne => {
      this.image = resposne;
    });
  }

  initializeForm() {
    this.imageForm = this.formBuilder.group({
      name: ['', Validators.required],
      createdBy: ['', Validators.required],
      id: [0, Validators.required]
    });
  }
}
