import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeRealListaComponent } from './trade-real-lista.component';

describe('TradeRealListaComponent', () => {
  let component: TradeRealListaComponent;
  let fixture: ComponentFixture<TradeRealListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeRealListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeRealListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
