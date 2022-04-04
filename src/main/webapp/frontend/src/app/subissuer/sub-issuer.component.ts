import {Component, OnInit} from '@angular/core';
import {SubIssuerService} from "./subIssuer.service";
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from 'file-saver';
import {Subissuer} from "./subissuer";
import {response} from "express";


@Component({
  selector: 'app-subissuer',
  templateUrl: './sub-issuer.component.html',
  styleUrls: ['./sub-issuer.component.css']
})
export class SubIssuerComponent implements OnInit {


  subIssuers: any;
  subIssuerForm: any;
  filename: string = "";
  private subIssuer: any;

  constructor(private subIssuerService: SubIssuerService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.initializeForm();
    this.getAllSubIssuer();

  }

  // TODO
  reloadData() {
    this.subIssuers = this.getAllSubIssuer()
  }

  deleteSubissuerByCode(code:string) {
    this.subIssuerService.deleteById(code)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }


  sendSubIssuerData() {
    console.log(this.subIssuerForm);
    let subIssuerData = this.subIssuerForm.value;
    this.subIssuerService.sendData(subIssuerData).subscribe(response => {
      this.filename = response;
    })
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

  getAllSubIssuer() {
    this.subIssuerService.getAllSubIssuer().subscribe(subIssuers => {
      this.subIssuers = subIssuers;
    });
  }


  downloadFile() {
    this.subIssuerService.downloadSqlFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }
}

