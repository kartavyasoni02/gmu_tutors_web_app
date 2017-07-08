import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ContactUsRoutingModule} from './contact-us-routing.module';
import {ContactPageComponent} from './contact-page/contact-page.component';

@NgModule({
    imports: [
        CommonModule,
        ContactUsRoutingModule
    ],
    declarations: [ContactPageComponent]
})
export class ContactUsModule {
}
