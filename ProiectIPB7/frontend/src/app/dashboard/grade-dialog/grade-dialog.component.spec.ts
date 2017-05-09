import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GradeDialogComponent } from './grade-dialog.component';

describe('GradeDialogComponent', () => {
  let component: GradeDialogComponent;
  let fixture: ComponentFixture<GradeDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GradeDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GradeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
