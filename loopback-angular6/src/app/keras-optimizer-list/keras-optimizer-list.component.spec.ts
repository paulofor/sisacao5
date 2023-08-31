import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KerasOptimizerListComponent } from './keras-optimizer-list.component';

describe('KerasOptimizerListComponent', () => {
  let component: KerasOptimizerListComponent;
  let fixture: ComponentFixture<KerasOptimizerListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KerasOptimizerListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KerasOptimizerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
