import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    {
        path: 'home',
        loadChildren: './home/home.module#HomeModule'
    },
    {
        path: 'contact',
        loadChildren: './contact-us/contact-us.module#ContactUsModule'
    },
    {
        path: 'tutors',
        loadChildren: './tutor-search/tutor-search.module#TutorSearchModule'
    },
    {
        path: 'map',
        loadChildren: './tutor-map/tutor-map.module#TutorMapModule'
    },
    {
        path: '**',
        loadChildren: './invalid-url/invalid-url.module#InvalidUrlModule'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
