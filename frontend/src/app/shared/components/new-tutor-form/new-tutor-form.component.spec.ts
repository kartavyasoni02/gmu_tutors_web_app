import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTutorFormComponent } from './new-tutor-form.component';

describe('NewTutorFormComponent', () => {
  let component: NewTutorFormComponent;
  let fixture: ComponentFixture<NewTutorFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewTutorFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTutorFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
