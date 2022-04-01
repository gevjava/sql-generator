import { Component, OnInit } from '@angular/core';
import {DeleteService} from "./delete.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  id:any;

  constructor(
    private service:DeleteService,
    private router: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.paramMap.get("id");
  }

  delete(){
    this.service.deleteSubissuer(this.id).subscribe(resposne => {console.log(resposne)});
  }

}
