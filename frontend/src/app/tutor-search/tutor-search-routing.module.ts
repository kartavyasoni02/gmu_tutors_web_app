import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TutorSearchPageComponent} from './tutor-search-page/tutor-search-page.component';

const routes: Routes = [
    {path: '', component: TutorSearchPageComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TutorSearchRoutingModule {
}
