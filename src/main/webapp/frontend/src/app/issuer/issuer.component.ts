import { Component, OnInit } from '@angular/core';
import {IssuerService} from "./issuer.service";

@Component({
  selector: 'app-issuer',
  templateUrl: './issuer.component.html',
  styleUrls: ['./issuer.component.css']
})
export class IssuerComponent implements OnInit {

  issuers: any;

  constructor(private issuerService: IssuerService) { }

  ngOnInit(): void {
    this.getAllIssuer();
  }

  getAllIssuer(){
    this.issuerService.getAllIssuer().subscribe(issuers => {
      this.issuers = issuers;
    });
  }
}
