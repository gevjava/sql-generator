import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Profileset } from '../profileset';
import { ProfilesetEditService } from './profileset-edit.service';

@Component({
  selector: 'app-profileset-edit',
  templateUrl: './profileset-edit.component.html',
  styleUrls: ['./profileset-edit.component.css']
})
export class ProfilesetEditComponent implements OnInit {

  id:any;
  profileset!: any;
  profileSetEditForm!: FormGroup;

  constructor(
    private profileSetEditService: ProfilesetEditService,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    this.show(this.id);
    this.initializeForm();
  }

  initializeForm(){
    this.profileSetEditForm = new FormGroup({
      createdBy: new FormControl(''),
      creationDate: new FormControl(''),
      name: new FormControl(''),
      updateState:new FormControl('')
    });
  }

  show(id:any){
     this.profileSetEditService.getById(id).subscribe(response => {this.profileset = response});
  }

  onEdit(data:any){
    this.profileSetEditService.update(data,this.id);
  }
}
