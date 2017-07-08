import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {InvalidUrlPageComponent} from './invalid-url-page/invalid-url-page.component';

const routes: Routes = [
    {path: '', component: InvalidUrlPageComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class InvalidUrlRoutingModule {
}
