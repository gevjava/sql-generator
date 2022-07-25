import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { IssuerService } from 'src/app/issuer/issuer.service';
import { SubIssuerService } from 'src/app/subissuer/subIssuer.service';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  issuers:any = [];
  subIssuers:any = [];
  profiles:any = [];

  profileForm: any;
  filename: String = "";

  myDate = new Date();

  constructor(
    private issuerService: IssuerService,
    private subIssuerService: SubIssuerService,
    private profileService: ProfileService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.index();
    this.initializeForm();
  }

  initializeForm(){
    this.profileForm = this.formBuilder.group({
      createdBy: ['', Validators.required],
      creationDate:['', Validators.required],
      description: ['', Validators.required],
      lastUpdateBy:  ['', Validators.required],
      name: ['', Validators.required],
      updateState:['',Validators.required],
      maxAttempts:['',Validators.required],
      dataEntryFormat: ['', Validators.required],
      dataEntryAllowedPattern: ['', Validators.required]
    });
  }

  index(){
    this.issuerService.getAllIssuer().subscribe(response => {this.issuers = response});
    this.subIssuerService.getAllSubIssuer().subscribe(response => {this.subIssuers = response});
    this.profileService.getAllProfiles().subscribe(response => {this.profiles = response});
  }

  onSubmit(data:any){

  }

  downloadFile(){

  }

}
