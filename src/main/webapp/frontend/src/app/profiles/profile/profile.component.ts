import { Component, OnInit } from '@angular/core';
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
  profileTerm!:string;
  showOnchange: boolean = false;

  constructor(
    private issuerService: IssuerService,
    private subIssuerService: SubIssuerService,
    private profileService: ProfileService
  ) { }

  ngOnInit(): void {
    this.index();
  }

  index(){
    this.issuerService.getAllIssuer().subscribe(response => {this.issuers = response});
    this.subIssuerService.getAllSubIssuer().subscribe(response => {this.subIssuers = response});
    this.profileService.getAllProfiles().subscribe(response => {this.profiles = response});
  }

  showBlock(){
    this.showOnchange = true;
  }

  hideBlock(){
    this.showOnchange = false;
  }

}
