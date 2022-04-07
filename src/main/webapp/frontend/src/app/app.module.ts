import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {IssuerComponent} from './issuer/issuer.component';
import {MainComponent} from './layouts/main/main.component';
import {NavbarComponent} from './layouts/navbar/navbar.component';
import {CryptoConfigComponent} from './cryptoconfig/crypto-config.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CryptoConfigService} from "./cryptoconfig/crypto-config.service";
import {IssuerService} from "./issuer/issuer.service";
import { AuthentmeansComponent } from './authentmeans/authentmeans.component';
import {AuthentmeansService} from "./authentmeans/authentmeans.service";

@NgModule({
  declarations: [
    CryptoConfigComponent,
    AppComponent,
    IssuerComponent,
    MainComponent,
    NavbarComponent,
    AuthentmeansComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [CryptoConfigService,AuthentmeansService,
    IssuerService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
