import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorSearchPageComponent } from './tutor-search-page.component';

describe('TutorSearchPageComponent', () => {
  let component: TutorSearchPageComponent;
  let fixture: ComponentFixture<TutorSearchPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TutorSearchPageComponent ]
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
