import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TutorMapRoutingModule } from './tutor-map-routing.module';
import { TutorMapDisplayComponent } from './tutor-map-display/tutor-map-display.component';

@NgModule({
  imports: [
    CommonModule,
    TutorMapRoutingModule
  ],
  declarations: [TutorMapDisplayComponent]
})
export class TutorMapModule { }
