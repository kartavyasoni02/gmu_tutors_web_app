import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {Ng2BootstrapModule} from 'ng-bootstrap/ng2-bootstrap';

import {
  ButtonModule, ChartModule, DataTableModule, DialogModule, GrowlModule, InputMaskModule, InputTextModule,
  SharedModule
} from "primeng/primeng";

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {HomeComponent} from './home/home.component';
import {InvalidUrlComponent} from './invalid-url/invalid-url.component';
import {FindTutorsComponent} from './find-tutors/find-tutors.component';
import {AboutComponent} from './about/about.component';
import {TutorService} from "./shared/services/tutor.service";
import {EnvConfig} from "./shared/services/env.config";
import { MessagingComponent } from './messaging/messaging.component';
import {MessagingService} from "./shared/services/messaging.service";
import { LoadingComponent } from './loading/loading.component';
import {LoadingService} from "./shared/services/loading.service";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    InvalidUrlComponent,
    FindTutorsComponent,
    AboutComponent,
    MessagingComponent,
    LoadingComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    Ng2BootstrapModule.forRoot(),
    DataTableModule, ButtonModule, DialogModule, GrowlModule, InputMaskModule, ChartModule,
    InputTextModule, SharedModule
  ],
  providers: [EnvConfig, TutorService, MessagingService, LoadingService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
