import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TutorsService} from './services/tutors/tutors.service';

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [],
    providers: [TutorsService]
})
export class SharedModule {
}
