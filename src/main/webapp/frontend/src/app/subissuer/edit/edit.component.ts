import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {EditService} from "./edit.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  id:any;
  subIssuerForm: any;
  filename: string = "";
  subIssuer: any;
  constructor(
    private service: EditService,
    private route: ActivatedRoute,
    private formBuilder:FormBuilder ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    this.initializeForm();
  }

  initializeForm() {
    this.subIssuerForm = this.formBuilder.group({
      acsId: ['', Validators.required],
      authenticationTimeOut: [0, [Validators.required, Validators.pattern("^[0-9]*$")]],
      defaultLanguage: ['', Validators.required],
      code: ['', Validators.required],
      codeSvi: ['', Validators.required],
      currencyCode: ['', Validators.required],
      createdBy:['', Validators.required],
      personnalDataStorage: [0, Validators.required],
      name: ['', Validators.required],
      authentMeans: ['', Validators.required],
      label: ['', Validators.required]
    });
  }

  updateSubIssuerData(){
     this.service.edit(this.subIssuerForm.value,this.id).subscribe(resposne => {console.log(resposne)});
  }

  downloadFile(){

  }
}
