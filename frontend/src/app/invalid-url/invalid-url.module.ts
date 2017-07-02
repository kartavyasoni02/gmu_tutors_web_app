import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InvalidUrlRoutingModule } from './invalid-url-routing.module';
import { InvalidUrlPageComponent } from './invalid-url-page/invalid-url-page.component';

@NgModule({
  imports: [
    CommonModule,
    InvalidUrlRoutingModule
  ],
  declarations: [InvalidUrlPageComponent]
})
export class InvalidUrlModule { }
