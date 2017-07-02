import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvalidUrlPageComponent } from './invalid-url-page.component';

describe('InvalidUrlPageComponent', () => {
  let component: InvalidUrlPageComponent;
  let fixture: ComponentFixture<InvalidUrlPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvalidUrlPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvalidUrlPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
