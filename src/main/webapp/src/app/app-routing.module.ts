import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {InvalidUrlComponent} from "./invalid-url/invalid-url.component";
import {FindTutorsComponent} from "./find-tutors/find-tutors.component";
import {AboutComponent} from "./about/about.component";
import {HomeComponent} from "./home/home.component";

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
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
