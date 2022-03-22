import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {IssuerComponent} from "./issuer/issuer.component";
import {SubissuerComponent} from "./subissuer/subissuer.component";

const routes: Routes = [
  {path: '', component: IssuerComponent},
  {path: 'subissuer', component: SubissuerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routesList = [IssuerComponent,SubissuerComponent];
