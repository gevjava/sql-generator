import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {IssuerComponent} from "./issuer/issuer.component";
import {EditComponent} from "./issuer/id/edit/edit.component";
import {DeleteComponent} from "./issuer/id/delete/delete.component";
import {CryptoConfigComponent} from "./cryptoconfig/crypto-config.component";
import {AuthentmeansComponent} from "./authentmeans/authentmeans.component";
import {ProfileComponent } from './profiles/profile/profile.component';
import {ProfilesetComponent } from './profiles/profileset/profileset.component';
import {SubIssuerComponent} from "./subissuer/sub-issuer.component";
import {EditsubissuerComponent} from "./subissuer/edit/editsubissuer.component";
import {DeletesubissuerComponent} from "./subissuer/delete/deletesubissuer.component";
import {ImageComponent} from "./image/image.component";
import {EditimageComponent} from "./image/edit/editimage.component";
import {ImagedeleteComponent} from "./image/delete/imagedelete.component";

const routes: Routes = [
  {path: 'image', component: ImageComponent},
  {path: 'image/edit/:id', component: EditimageComponent},
  {path: 'image/delete/:id', component: ImagedeleteComponent},
  {path: 'profile',component: ProfileComponent},
  {path: 'profileset',component: ProfilesetComponent},
  {path: 'subissuer', component: SubIssuerComponent},
  {path: 'issuer/:code/edit',component:EditComponent},
  {path: 'issuer/:code/delete', component:DeleteComponent},
  {path: 'crypto', component: CryptoConfigComponent},
  {path: 'authent', component: AuthentmeansComponent},
  {path: '', component: IssuerComponent},
  {path: '', component:SubIssuerComponent},
  {path: 'subissuer/:code/edit', component:EditsubissuerComponent},
  {path: 'subissuer/:code/delete',component:DeletesubissuerComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routesList = [IssuerComponent,SubIssuerComponent,EditComponent,DeleteComponent,ProfileComponent,
  ProfilesetComponent,EditsubissuerComponent,DeletesubissuerComponent,ImageComponent,EditimageComponent,ImagedeleteComponent,
  CryptoConfigComponent, AuthentmeansComponent];


