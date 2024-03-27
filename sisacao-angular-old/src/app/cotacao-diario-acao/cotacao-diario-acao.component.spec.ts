import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoDiarioAcaoComponent } from './cotacao-diario-acao.component';

describe('CotacaoDiarioAcaoComponent', () => {
  let component: CotacaoDiarioAcaoComponent;
  let fixture: ComponentFixture<CotacaoDiarioAcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoDiarioAcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoDiarioAcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
