import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TutorSearchRoutingModule } from './tutor-search-routing.module';
import { TutorSearchPageComponent } from './tutor-search-page/tutor-search-page.component';
import { TutorListViewComponent } from './components/tutor-list-view/tutor-list-view.component';
import { TutorCardComponent } from './components/tutor-card/tutor-card.component';

@NgModule({
  imports: [
    CommonModule,
    TutorSearchRoutingModule
  ],
  declarations: [TutorSearchPageComponent, TutorListViewComponent, TutorCardComponent]
})
export class TutorSearchModule { }
