import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IssuerComponent} from "./issuer/issuer.component";
import {EditComponent} from "./issuer/id/edit/edit.component";
import {DeleteComponent} from "./issuer/id/delete/delete.component";
import {CryptoConfigComponent} from "./cryptoconfig/crypto-config.component";
import {AuthentmeansComponent} from "./authentmeans/authentmeans.component";
import {ProfileComponent} from './profiles/profile/profile.component';
import {ProfilesetComponent} from './profiles/profileset/profileset.component';
import {SubIssuerComponent} from "./subissuer/sub-issuer.component";
import {EditsubissuerComponent} from "./subissuer/edit/editsubissuer.component";
import {DeletesubissuerComponent} from "./subissuer/delete/deletesubissuer.component";
import {ImageComponent} from "./image/image.component";
import {EditimageComponent} from "./image/edit/editimage.component";
import {DeleteImageComponent} from "./image/delete/delete-image.component";
import {RuleComponent} from './rule/rule.component';
import {RuleDeleteComponent} from "./rule/rule-delete/rule-delete.component";
import {RuleEditComponent} from "./rule/rule-edit/rule-edit.component";
import {RuleConditionComponent} from "./rulecondition/rule-condition.component";
import {ConditionDeleteComponent} from "./rulecondition/conditiondelete/condition-delete.component";
import {ConditionEditComponent} from "./rulecondition/conditionedit/condition-edit.component";
import { ProfileEditComponent } from './profiles/profile/profile-edit/profile-edit.component';
import { ProfileDeleteComponent } from './profiles/profile/profile-delete/profile-delete.component';
import { ProfilesetEditComponent } from './profiles/profileset/profileset-edit/profileset-edit.component';
import { ProfilesetDeleteComponent } from './profiles/profileset/profileset-delete/profileset-delete.component';

const routes: Routes = [
  {path: 'image', component: ImageComponent},
  {path: 'image/edit/:id', component: EditimageComponent},
  {path: 'image/delete/:id', component: DeleteImageComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'profileset', component: ProfilesetComponent},
  {path: 'subissuer', component: SubIssuerComponent},
  {path: 'crypto', component: CryptoConfigComponent},
  {path: 'authent', component: AuthentmeansComponent},
  {path: '', component: IssuerComponent},
  {path: '', component: SubIssuerComponent},
  {path: 'subissuer/:code/edit', component: EditsubissuerComponent},
  {path: 'subissuer/:code/delete', component: DeletesubissuerComponent},
  {path: 'rule', component: RuleComponent},
  {path: 'rule/delete/:id', component: RuleDeleteComponent},
  {path: 'rule/edit/:id', component: RuleEditComponent},
  {path: 'condition', component: RuleConditionComponent},
  {path: 'condition/delete/:id', component: ConditionDeleteComponent},
  {path: 'condition/edit/:id', component: ConditionEditComponent},
  { path: 'profile/:id/edit', component: ProfileEditComponent },
  { path: 'profile/:id/delete', component: ProfileDeleteComponent },
  { path: 'profileset/:id/edit', component: ProfilesetEditComponent },
  { path: 'profileset/:id/delete', component: ProfilesetDeleteComponent },
  { path: 'issuer/:id/edit', component: EditComponent },
  { path: 'issuer/:id/delete', component: DeleteComponent },
  { path: '', component: IssuerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routesList = [IssuerComponent, EditComponent, DeleteComponent,
  ProfileComponent, ProfilesetComponent,
  CryptoConfigComponent, AuthentmeansComponent,
  SubIssuerComponent, EditsubissuerComponent, DeletesubissuerComponent,
  ImageComponent, EditimageComponent, DeleteImageComponent,
  RuleComponent, RuleDeleteComponent,RuleEditComponent,
  RuleConditionComponent, ConditionDeleteComponent, ConditionEditComponent,
  ProfileEditComponent, ProfileDeleteComponent,
  ProfilesetEditComponent, ProfilesetDeleteComponent
];


