import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {Ng2BootstrapModule} from 'ng-bootstrap/ng2-bootstrap';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {InvalidUrlComponent} from './invalid-url/invalid-url.component';
import {FindTutorsComponent} from './find-tutors/find-tutors.component';
import {AboutComponent} from './about/about.component';
import {TutorService} from "./shared/tutor.service";
import {DataTableModule} from "primeng/components/datatable/datatable";
import {ButtonModule} from "primeng/components/button/button";
import {EnvConfig} from "./shared/env.config";
import {SharedModule} from "primeng/components/common/shared";
import {DialogModule} from "primeng/primeng";
import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    InvalidUrlComponent,
    FindTutorsComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    Ng2BootstrapModule.forRoot(),
    DataTableModule, ButtonModule, DialogModule, SharedModule
  ],
  providers: [EnvConfig, TutorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
