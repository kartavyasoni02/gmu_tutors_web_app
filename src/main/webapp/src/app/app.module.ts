import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {InvalidUrlComponent} from './invalid-url/invalid-url.component';
import {FindTutorsComponent} from './find-tutors/find-tutors.component';
import {AboutComponent} from './about/about.component';
import {RouterModule, Routes} from "@angular/router";

const appRoutes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'find-tutors',
    component: FindTutorsComponent
  },
  {
    path: '404',
    component: InvalidUrlComponent
  },
  {
    path: '**',
    redirectTo: '404'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    InvalidUrlComponent,
    FindTutorsComponent,
    AboutComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
