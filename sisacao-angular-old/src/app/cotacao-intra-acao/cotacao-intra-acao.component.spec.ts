import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntraAcaoComponent } from './cotacao-intra-acao.component';

describe('CotacaoIntraAcaoComponent', () => {
  let component: CotacaoIntraAcaoComponent;
  let fixture: ComponentFixture<CotacaoIntraAcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntraAcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntraAcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
