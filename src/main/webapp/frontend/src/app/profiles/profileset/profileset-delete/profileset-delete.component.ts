import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProfilesetDeleteService } from './profileset-delete.service';

@Component({
  selector: 'app-profileset-delete',
  templateUrl: './profileset-delete.component.html',
  styleUrls: ['./profileset-delete.component.css']
})
export class ProfilesetDeleteComponent implements OnInit {

  response:any;
  id:any;

  constructor(
    private profileSetDeleteService: ProfilesetDeleteService,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
  }

  destroy(){
    this.profileSetDeleteService.remove(this.id).subscribe(response => {console.log(response)});
  }

}
