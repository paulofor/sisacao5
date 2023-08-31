import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KerasLossListComponent } from './keras-loss-list.component';

describe('KerasLossListComponent', () => {
  let component: KerasLossListComponent;
  let fixture: ComponentFixture<KerasLossListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KerasLossListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KerasLossListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
