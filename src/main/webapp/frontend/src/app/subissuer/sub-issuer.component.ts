import {Component, OnInit} from '@angular/core';
import {SubIssuerService} from "./subIssuer.service";
import {FormBuilder, Validators} from "@angular/forms";
import {saveAs} from 'file-saver';

@Component({
  selector: 'app-subissuer',
  templateUrl: './sub-issuer.component.html',
  styleUrls: ['./sub-issuer.component.css']
})
export class SubIssuerComponent implements OnInit {

  subIssuers: any;
  subIssuerForm: any;
  filename: string = "";

  constructor(private subIssuerService: SubIssuerService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.initializeForm();
    this.getAllSubIssuer();
  }

  initializeForm() {
    this.subIssuerForm = this.formBuilder.group({
      code: ['', Validators.required],
      name: ['', Validators.required],
      authentMeans: ['', Validators.required]
    });
  }

  getAllSubIssuer() {
    this.subIssuerService.getAllSubIssuer().subscribe(subIssuers => {
      this.subIssuers = subIssuers;
    });
  }

  sendSubIssuerData() {
    let subIssuerData = this.subIssuerForm.value;
    this.subIssuerService.sendSubIssuerData(subIssuerData).subscribe(response => {
      this.filename = response;
    })
  }

  downloadFile() {
    this.subIssuerService.downloadFile(this.filename).subscribe(file => saveAs(file, this.filename));
  }
}

