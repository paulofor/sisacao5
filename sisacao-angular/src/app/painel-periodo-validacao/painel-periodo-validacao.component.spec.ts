import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelPeriodoValidacaoComponent } from './painel-periodo-validacao.component';

describe('PainelPeriodoValidacaoComponent', () => {
  let component: PainelPeriodoValidacaoComponent;
  let fixture: ComponentFixture<PainelPeriodoValidacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PainelPeriodoValidacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PainelPeriodoValidacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
