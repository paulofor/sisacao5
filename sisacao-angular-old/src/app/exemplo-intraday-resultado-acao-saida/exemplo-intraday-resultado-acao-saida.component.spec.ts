import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExemploIntradayResultadoAcaoSaidaComponent } from './exemplo-intraday-resultado-acao-saida.component';

describe('ExemploIntradayResultadoAcaoSaidaComponent', () => {
  let component: ExemploIntradayResultadoAcaoSaidaComponent;
  let fixture: ComponentFixture<ExemploIntradayResultadoAcaoSaidaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExemploIntradayResultadoAcaoSaidaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExemploIntradayResultadoAcaoSaidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
