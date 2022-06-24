import { Component, OnInit } from '@angular/core';
import {IssuerService} from "./issuer.service";
import {FormBuilder, FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-issuer',
  templateUrl: './issuer.component.html',
  styleUrls: ['./issuer.component.css']
})
export class IssuerComponent implements OnInit {

  issuers: any = [];
  filename: string ="";
  filterTerm!: string;
  showOnchange: boolean = false;
  issuer: string = '';
  id!: string | null;

  issuerForm: any;


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
      code: new FormControl(''),
      createdBy: new FormControl(''),
      creationDate: new FormControl(''),
      name:new FormControl(''),
      updateState:new FormControl(''),
      label:new FormControl(''),
      availaibleAuthentMeans: new FormControl('')
    });
  }

  onSubmit(data:any){
    this.issuerService.sendIssuerData(data.value).subscribe(response => {console.log(response)});
  }

  getAllIssuer(){
    this.issuerService.getAllIssuer().subscribe(issuers => {
      this.issuers = issuers;
    });
  }

  listOfIssuers(){
    this.showOnchange = true;
  }

  

}
