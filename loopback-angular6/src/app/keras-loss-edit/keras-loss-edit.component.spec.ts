import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KerasLossEditComponent } from './keras-loss-edit.component';

describe('KerasLossEditComponent', () => {
  let component: KerasLossEditComponent;
  let fixture: ComponentFixture<KerasLossEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KerasLossEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KerasLossEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
