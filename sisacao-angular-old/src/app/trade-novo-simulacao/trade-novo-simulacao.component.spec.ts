import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeNovoSimulacaoComponent } from './trade-novo-simulacao.component';

describe('TradeNovoSimulacaoComponent', () => {
  let component: TradeNovoSimulacaoComponent;
  let fixture: ComponentFixture<TradeNovoSimulacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeNovoSimulacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeNovoSimulacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
