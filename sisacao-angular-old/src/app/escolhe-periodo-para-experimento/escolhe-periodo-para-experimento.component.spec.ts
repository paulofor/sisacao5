import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolhePeriodoParaExperimentoComponent } from './escolhe-periodo-para-experimento.component';

describe('EscolhePeriodoParaExperimentoComponent', () => {
  let component: EscolhePeriodoParaExperimentoComponent;
  let fixture: ComponentFixture<EscolhePeriodoParaExperimentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolhePeriodoParaExperimentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolhePeriodoParaExperimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
