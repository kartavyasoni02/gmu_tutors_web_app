import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TutorsService} from './services/tutors/tutors.service';
import { NewTutorFormComponent } from './components/new-tutor-form/new-tutor-form.component';

@NgModule({
    imports: [
        CommonModule
    ],
    exports: [NewTutorFormComponent],
    declarations: [NewTutorFormComponent],
    providers: [TutorsService]
})
export class SharedModule {
}
