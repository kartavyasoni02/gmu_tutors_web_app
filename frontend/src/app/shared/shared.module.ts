import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TutorsService } from './services/tutors/tutors.service';
import {MdCardModule} from '@angular/material';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [TutorsService]
})
export class SharedModule { }
