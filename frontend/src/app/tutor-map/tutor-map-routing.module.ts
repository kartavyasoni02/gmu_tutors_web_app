import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TutorMapDisplayComponent} from './tutor-map-display/tutor-map-display.component';

const routes: Routes = [
    {path: '', component: TutorMapDisplayComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TutorMapRoutingModule {
}
