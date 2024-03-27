import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PontoEntradaSimulacaoDiaComponent } from './ponto-entrada-simulacao-dia.component';

describe('PontoEntradaSimulacaoDiaComponent', () => {
  let component: PontoEntradaSimulacaoDiaComponent;
  let fixture: ComponentFixture<PontoEntradaSimulacaoDiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PontoEntradaSimulacaoDiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PontoEntradaSimulacaoDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
