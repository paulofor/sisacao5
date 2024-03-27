import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntradayResultadoAcaoComponent } from './cotacao-intraday-resultado-acao.component';

describe('CotacaoIntradayResultadoAcaoComponent', () => {
  let component: CotacaoIntradayResultadoAcaoComponent;
  let fixture: ComponentFixture<CotacaoIntradayResultadoAcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntradayResultadoAcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntradayResultadoAcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
