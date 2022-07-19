import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ProfileEditServiceService } from './profile-edit-service.service';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  id: any;
  profile: any = null;

  // @ts-ignore
  profileEditForm: FormGroup;

  constructor(
    private service: ProfileEditServiceService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("code");
    this.getOneProfile(this.id);
    this.initializeForm();
  }

  initializeForm() {
    this.profileEditForm = new FormGroup({
      createdBy: new FormControl(''),
      creationDate: new FormControl(''),
      name: new FormControl(''),
      updateState: new FormControl('')
    });
  }

  getOneProfile(id: any) {
    this.service.getProfileById(id).subscribe(response => { this.profile = response })
  }

  onEdit(profile: any) {
    this.service.edit(profile.value,this.id).subscribe(response => {console.log(response)})
  }

}
