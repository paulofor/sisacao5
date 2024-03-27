import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorMonitoriaPeriodoTabelaComponent } from './valor-monitoria-periodo-tabela.component';

describe('ValorMonitoriaPeriodoTabelaComponent', () => {
  let component: ValorMonitoriaPeriodoTabelaComponent;
  let fixture: ComponentFixture<ValorMonitoriaPeriodoTabelaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValorMonitoriaPeriodoTabelaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValorMonitoriaPeriodoTabelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
