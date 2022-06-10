import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule, routesList} from './app-routing.module';
import {AppComponent} from './app.component';
import {MainComponent} from './layouts/main/main.component';
import {NavbarComponent} from './layouts/navbar/navbar.component';
import {ImageComponent} from './image/image.component';
import {EditimageComponent} from './image/edit/editimage.component';
import {DeleteImageComponent} from './image/delete/delete-image.component';
import {RuleComponent} from './rule/rule.component';
import {RuleDeleteComponent} from './rule/rule-delete/rule-delete.component';
import {RuleEditComponent} from './rule/rule-edit/rule-edit.component';
import {RuleConditionComponent} from './rulecondition/rule-condition.component';
import {ConditionEditComponent} from './rulecondition/conditionedit/condition-edit.component';
import {ConditionDeleteComponent} from './rulecondition/conditiondelete/condition-delete.component';
import { CryptoConfigComponent } from "./cryptoconfig/crypto-config.component";
import { AuthentmeansComponent } from "./authentmeans/authentmeans.component";


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavbarComponent,
    routesList,
    ImageComponent,
    EditimageComponent,
    DeleteImageComponent,
    RuleComponent,
    RuleDeleteComponent,
    RuleEditComponent,
    RuleConditionComponent,
    ConditionEditComponent,
    ConditionDeleteComponent,
    CryptoConfigComponent,
    AuthentmeansComponent,
    routesList
  ],

  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgbModule,
    Ng2SearchPipeModule,
    FormsModule,
    ReactiveFormsModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
