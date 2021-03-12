import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeExecucaoSimulacaoComponent } from './trade-execucao-simulacao.component';

describe('TradeExecucaoSimulacaoComponent', () => {
  let component: TradeExecucaoSimulacaoComponent;
  let fixture: ComponentFixture<TradeExecucaoSimulacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeExecucaoSimulacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeExecucaoSimulacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
