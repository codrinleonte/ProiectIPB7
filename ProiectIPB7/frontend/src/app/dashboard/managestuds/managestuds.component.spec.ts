import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagestudsComponent } from './managestuds.component';

describe('ManagestudsComponent', () => {
  let component: ManagestudsComponent;
  let fixture: ComponentFixture<ManagestudsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagestudsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagestudsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
