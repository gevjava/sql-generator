import { Component, OnInit } from '@angular/core';
import {ProfilesetService} from "./profileset.service";

@Component({
  selector: 'app-profileset',
  templateUrl: './profileset.component.html',
  styleUrls: ['./profileset.component.css']
})
export class ProfilesetComponent implements OnInit {

  profilesets : any = [];
  showOnchange: boolean = false;

  constructor(
    private profileSetService: ProfilesetService,

    ) { }

  ngOnInit(): void {
    this.index();
  }

  index(){
    this.profileSetService.getAllProfileSets().subscribe(response => {this.profilesets = response});
  }

  showBlock(){
    this.showOnchange = true;
  }


}
