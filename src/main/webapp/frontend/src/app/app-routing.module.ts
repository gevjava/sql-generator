import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IssuerComponent} from "./issuer/issuer.component";
import {EditComponent} from "./issuer/id/edit/edit.component";
import {DeleteComponent} from "./issuer/id/delete/delete.component";
import {ProfilesetComponent} from './profiles/profileset/profileset.component';
import {CryptoConfigComponent} from "./cryptoconfig/crypto-config.component";
import {AuthentmeansComponent} from "./authentmeans/authentmeans.component";
import {ProfileComponent} from './profiles/profile/profile.component';
import {SubIssuerComponent} from "./subissuer/sub-issuer.component";
import {EditsubissuerComponent} from "./subissuer/edit/editsubissuer.component";
import {DeletesubissuerComponent} from "./subissuer/delete/deletesubissuer.component";
import { ProfileEditComponent } from './profiles/profile/profile-edit/profile-edit.component';
import { ProfileDeleteComponent } from './profiles/profile/profile-delete/profile-delete.component';
import { ProfilesetEditComponent } from './profiles/profileset/profileset-edit/profileset-edit.component';
import { ProfilesetDeleteComponent } from './profiles/profileset/profileset-delete/profileset-delete.component';

const routes: Routes = [
  {path: 'profile/:code/edit', component: ProfileEditComponent},
  {path: 'profile/:code/delete', component:ProfileDeleteComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'profileset/:code/edit', component:ProfilesetEditComponent},
  {path: 'profileset/:code/delete', component:ProfilesetDeleteComponent},
  {path: 'profileset', component: ProfilesetComponent},
  {path: 'crypto', component: CryptoConfigComponent},
  {path: 'authent', component: AuthentmeansComponent},
  {path: 'subissuer/:code/edit', component: EditsubissuerComponent},
  {path: 'subissuer/:code/delete', component: DeletesubissuerComponent},
  {path: 'subissuer', component: SubIssuerComponent},
  {path: 'issuer/:code/edit', component: EditComponent},
  {path: 'issuer/:code/delete', component: DeleteComponent},
  {path: '', component: IssuerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routesList = [IssuerComponent, EditComponent, DeleteComponent, ProfileComponent,
  ProfilesetComponent,SubIssuerComponent, EditsubissuerComponent, DeletesubissuerComponent, CryptoConfigComponent, 
  AuthentmeansComponent,ProfileEditComponent,ProfileDeleteComponent,ProfilesetEditComponent,ProfilesetDeleteComponent];


