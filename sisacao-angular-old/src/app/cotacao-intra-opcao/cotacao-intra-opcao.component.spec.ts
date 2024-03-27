import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntraOpcaoComponent } from './cotacao-intra-opcao.component';

describe('CotacaoIntraOpcaoComponent', () => {
  let component: CotacaoIntraOpcaoComponent;
  let fixture: ComponentFixture<CotacaoIntraOpcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntraOpcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntraOpcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
