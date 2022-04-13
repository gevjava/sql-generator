import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {IssuerComponent} from "./issuer/issuer.component";
import {SubissuerComponent} from "./subissuer/subissuer.component";
import {EditComponent} from "./issuer/id/edit/edit.component";
import {DeleteComponent} from "./issuer/id/delete/delete.component";
import { ProfileComponent } from './profiles/profile/profile.component';
import { ProfilesetComponent } from './profiles/profileset/profileset.component';

const routes: Routes = [
  {path: 'profile',component: ProfileComponent},
  {path: 'profileset',component: ProfilesetComponent},
  {path: 'subissuer', component: SubissuerComponent},
  {path: 'issuer/:code/edit',component:EditComponent},
  {path: 'issuer/:code/delete', component:DeleteComponent},
  {path: '', component: IssuerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routesList = [IssuerComponent,SubissuerComponent,EditComponent,DeleteComponent,ProfileComponent,ProfilesetComponent];
