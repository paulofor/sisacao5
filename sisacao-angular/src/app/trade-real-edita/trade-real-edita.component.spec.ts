import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeRealEditaComponent } from './trade-real-edita.component';

describe('TradeRealEditaComponent', () => {
  let component: TradeRealEditaComponent;
  let fixture: ComponentFixture<TradeRealEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeRealEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeRealEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
