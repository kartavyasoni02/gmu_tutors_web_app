import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorMapDisplayComponent } from './tutor-map-display.component';

describe('TutorMapDisplayComponent', () => {
  let component: TutorMapDisplayComponent;
  let fixture: ComponentFixture<TutorMapDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TutorMapDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorMapDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
