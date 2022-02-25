import { Component, OnInit } from '@angular/core';
import {IssuerService} from "./issuer.service";
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from 'file-saver';

@Component({
  selector: 'app-issuer',
  templateUrl: './issuer.component.html',
  styleUrls: ['./issuer.component.css']
})
export class IssuerComponent implements OnInit {

  issuers: any;
  issuerForm: any;
  filename: string ="";

  constructor(private issuerService: IssuerService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.initializeForm();
    this.getAllIssuer();
  }

  initializeForm(){
    this.issuerForm = this.formBuilder.group({
      code: ['', Validators.required],
      name: ['', Validators.required],
      createdBy: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  getAllIssuer(){
    this.issuerService.getAllIssuer().subscribe(issuers => {
      this.issuers = issuers;
    });
  }

  sendIssuerData(){
    let issuerData = this.issuerForm.value;
    this.issuerService.sendIssuerData(issuerData).subscribe(response => {this.filename = response;})
  }

  downloadFile(){
    this.issuerService.downloadFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }
}
