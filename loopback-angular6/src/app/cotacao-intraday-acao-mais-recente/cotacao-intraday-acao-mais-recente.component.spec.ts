import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntradayAcaoMaisRecenteComponent } from './cotacao-intraday-acao-mais-recente.component';

describe('CotacaoIntradayAcaoMaisRecenteComponent', () => {
  let component: CotacaoIntradayAcaoMaisRecenteComponent;
  let fixture: ComponentFixture<CotacaoIntradayAcaoMaisRecenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntradayAcaoMaisRecenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntradayAcaoMaisRecenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
