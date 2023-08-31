import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlocacaoSaldoMesEdicaoComponent } from './alocacao-saldo-mes-edicao.component';

describe('AlocacaoSaldoMesEdicaoComponent', () => {
  let component: AlocacaoSaldoMesEdicaoComponent;
  let fixture: ComponentFixture<AlocacaoSaldoMesEdicaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlocacaoSaldoMesEdicaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlocacaoSaldoMesEdicaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
