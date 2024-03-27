import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecucaoSimulacaoPorExperimentoComponent } from './execucao-simulacao-por-experimento.component';

describe('ExecucaoSimulacaoPorExperimentoComponent', () => {
  let component: ExecucaoSimulacaoPorExperimentoComponent;
  let fixture: ComponentFixture<ExecucaoSimulacaoPorExperimentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExecucaoSimulacaoPorExperimentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecucaoSimulacaoPorExperimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
