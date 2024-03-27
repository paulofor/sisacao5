import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeRealVisualComponent } from './trade-real-visual.component';

describe('TradeRealVisualComponent', () => {
  let component: TradeRealVisualComponent;
  let fixture: ComponentFixture<TradeRealVisualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeRealVisualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeRealVisualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
