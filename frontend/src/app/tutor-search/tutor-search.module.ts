import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {TutorSearchRoutingModule} from './tutor-search-routing.module';
import {TutorSearchPageComponent} from './tutor-search-page/tutor-search-page.component';
import {TutorListViewComponent} from './components/tutor-list-view/tutor-list-view.component';
import {SharedModule} from '../shared/shared.module';
import {MdButtonModule, MdCardModule, MdListModule} from '@angular/material';

@NgModule({
    imports: [
        CommonModule,
        TutorSearchRoutingModule,
        SharedModule,
        MdListModule,
        MdCardModule,
        MdButtonModule
    ],
    declarations: [TutorSearchPageComponent, TutorListViewComponent]
})
export class TutorSearchModule {
}
