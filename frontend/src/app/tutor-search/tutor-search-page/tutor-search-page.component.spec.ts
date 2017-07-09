import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TutorSearchPageComponent} from './tutor-search-page.component';
import {TutorListViewComponent} from '../components/tutor-list-view/tutor-list-view.component';
import {SharedModule} from '../../shared/shared.module';
import {MdButtonModule, MdCardModule, MdListModule} from '@angular/material';

describe('TutorSearchPageComponent', () => {
    let component: TutorSearchPageComponent;
    let fixture: ComponentFixture<TutorSearchPageComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TutorSearchPageComponent, TutorListViewComponent],
            imports: [
                SharedModule,
                MdListModule,
                MdCardModule,
                MdButtonModule
            ]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(TutorSearchPageComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should be created', () => {
        expect(component).toBeTruthy();
    });
});
