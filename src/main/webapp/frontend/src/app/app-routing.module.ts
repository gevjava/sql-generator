import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EditComponent} from "./subissuer/edit/edit.component";
import {DeleteComponent} from "./subissuer/delete/delete.component";
import {SubIssuerComponent} from "./subissuer/sub-issuer.component";

const routes: Routes = [
  {path:'', component:SubIssuerComponent},
  {path: 'subissuer/:code/edit', component:EditComponent},
  {path: 'subissuer/:code/delete',component:DeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routesList = [SubIssuerComponent,EditComponent,DeleteComponent];
