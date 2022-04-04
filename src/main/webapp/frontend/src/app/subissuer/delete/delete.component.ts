import { Component, OnInit } from '@angular/core';
import {DeleteService} from "./delete.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  code:any;

  constructor(
    private service:DeleteService,
    private router: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.code = this.router.snapshot.paramMap.get("code");
  }

  delete(){
    this.service.deleteSubissuer(this.code).subscribe(resposne => {console.log(resposne)});
  }

}
