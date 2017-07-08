import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ContactUsModule} from './contact-us/contact-us.module';
import {HomeModule} from './home/home.module';
import {InvalidUrlModule} from './invalid-url/invalid-url.module';
import {TutorProfileModule} from './tutor-profile/tutor-profile.module';
import {TutorSearchModule} from './tutor-search/tutor-search.module';
import {MdButtonModule, MdIconModule, MdMenuModule, MdTabsModule, MdToolbarModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        ContactUsModule,
        HomeModule,
        InvalidUrlModule,
        TutorProfileModule,
        TutorSearchModule,
        MdToolbarModule,
        MdTabsModule,
        MdButtonModule,
        MdIconModule,
        MdMenuModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
