import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KerasOptimizerEditComponent } from './keras-optimizer-edit.component';

describe('KerasOptimizerEditComponent', () => {
  let component: KerasOptimizerEditComponent;
  let fixture: ComponentFixture<KerasOptimizerEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KerasOptimizerEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KerasOptimizerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
