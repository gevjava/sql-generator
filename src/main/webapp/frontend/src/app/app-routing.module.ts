import {RouterModule, Routes} from "@angular/router";
import {IssuerComponent} from "./issuer/issuer.component";
import {CryptoConfigComponent} from "./cryptoconfig/crypto-config.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  {path: '', component: IssuerComponent},
  {path: 'crypto', component: CryptoConfigComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routesList = [CryptoConfigComponent];
