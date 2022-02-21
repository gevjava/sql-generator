import {Component, OnInit} from '@angular/core';
import {SubIssuerService} from "./subIssuer.service";


@Component({
  selector: 'app-subissuer',
  templateUrl: './sub-issuer.component.html',
  styleUrls: ['./sub-issuer.component.css']
})
export class SubIssuerComponent implements OnInit {

  subIssuers: any;

  constructor(private subIssuerService: SubIssuerService) {
  }

  ngOnInit(): void {
    this.getAllSubIssuer();
  }

  getAllSubIssuer() {
    this.subIssuerService.getAllSubIssuer().subscribe(subIssuers => {
      this.subIssuers = subIssuers;
    });
  }

}


