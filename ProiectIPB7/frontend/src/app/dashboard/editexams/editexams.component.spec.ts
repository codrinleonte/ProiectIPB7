import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditexamsComponent } from './editexams.component';

describe('EditexamsComponent', () => {
  let component: EditexamsComponent;
  let fixture: ComponentFixture<EditexamsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditexamsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditexamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
