import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlocacaoSaldoMesComponent } from './alocacao-saldo-mes.component';

describe('AlocacaoSaldoMesComponent', () => {
  let component: AlocacaoSaldoMesComponent;
  let fixture: ComponentFixture<AlocacaoSaldoMesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlocacaoSaldoMesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlocacaoSaldoMesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
