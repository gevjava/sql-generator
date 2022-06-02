import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule,routesList } from './app-routing.module';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { CryptoConfigComponent } from "./cryptoconfig/crypto-config.component";
import { AuthentmeansComponent } from "./authentmeans/authentmeans.component";
import { ProfileEditComponent } from './profiles/profile/profile-edit/profile-edit.component';
import { ProfileDeleteComponent } from './profiles/profile/profile-delete/profile-delete.component';
import { ProfilesetDeleteComponent } from './profiles/profileset/profileset-delete/profileset-delete.component';
import { ProfilesetEditComponent } from './profiles/profileset/profileset-edit/profileset-edit.component';



@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavbarComponent,
    CryptoConfigComponent,
    AuthentmeansComponent,
    routesList

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgbModule,
    Ng2SearchPipeModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
