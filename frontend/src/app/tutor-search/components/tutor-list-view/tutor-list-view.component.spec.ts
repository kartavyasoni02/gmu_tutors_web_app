import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TutorListViewComponent} from './tutor-list-view.component';
import {MdListModule} from '@angular/material';
import {SharedModule} from '../../../shared/shared.module';

describe('TutorListViewComponent', () => {
  let component: TutorListViewComponent;
  let fixture: ComponentFixture<TutorListViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TutorListViewComponent],
      imports: [SharedModule, MdListModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
