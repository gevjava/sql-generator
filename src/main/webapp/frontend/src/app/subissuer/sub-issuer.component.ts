import {Component, OnInit} from '@angular/core';
import {SubIssuerService} from "./subIssuer.service";
import {Subissuer} from "./subissuer";



@Component({
  selector: 'app-subissuer',
  templateUrl: './sub-issuer.component.html',
  styleUrls: ['./sub-issuer.component.css']
})
export class SubIssuerComponent implements OnInit {

  subIssuers: any;
  subIssuer: Subissuer = new Subissuer();

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

  add(subIssuer: Subissuer){
     this.subIssuerService.add(subIssuer).subscribe(data => {console.log(data)});
     }
  }




//save(customItem: CustomItem) {
//   this.customItemService
//     .postCustomItem(customItem).subscribe(customItem => {
//       console.log(customItem)
//       this.customItem = new CustomItem();
//       this.gotoList();
//     },
//     error => console.log(error));
//
// }
