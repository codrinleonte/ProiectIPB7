import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelButtonComponent } from './panel-button.component';

describe('PanelButtonComponent', () => {
  let component: PanelButtonComponent;
  let fixture: ComponentFixture<PanelButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PanelButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
