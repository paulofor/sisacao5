import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PontoEntradaSimulacaoDiaVendaComponent } from './ponto-entrada-simulacao-dia-venda.component';

describe('PontoEntradaSimulacaoDiaVendaComponent', () => {
  let component: PontoEntradaSimulacaoDiaVendaComponent;
  let fixture: ComponentFixture<PontoEntradaSimulacaoDiaVendaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PontoEntradaSimulacaoDiaVendaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PontoEntradaSimulacaoDiaVendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
