import { Component, OnInit } from '@angular/core';
import {IssuerService} from "./issuer.service";
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from "file-saver";

@Component({
  selector: 'app-issuer',
  templateUrl: './issuer.component.html',
  styleUrls: ['./issuer.component.css']
})
export class IssuerComponent implements OnInit {

  issuers: any = [];
  filename: string ="";
  issuer: string = '';
  id!: string | null;

  issuerForm: any;
  myDate = new Date();

  constructor(
    private issuerService: IssuerService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.getAllIssuer();
    this.initializeForm();
  }

  initializeForm(){
    this.issuerForm = this.formBuilder.group({
      code: ['', Validators.required],
      createdBy: ['', Validators.required],
      creationDate:['', Validators.required],
      name: ['', Validators.required],
      updateState:['',Validators.required],
      label:['',Validators.required],
      availaibleAuthentMeans: ['', Validators.required]
    });
  }

  onSubmit(data: any){
    this.issuerService.sendIssuerData(data.value).subscribe(response =>
          this.filename = response
    );
  }

  getAllIssuer(){
    this.issuerService.getAllIssuer().subscribe(issuers => {
       this.issuers = issuers;
    });
  }

  downloadFile() {
    this.issuerService.downloadSqlFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }

}
