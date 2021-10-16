import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolhePeriodoCorrenteExperimentoComponent } from './escolhe-periodo-corrente-experimento.component';

describe('EscolhePeriodoCorrenteExperimentoComponent', () => {
  let component: EscolhePeriodoCorrenteExperimentoComponent;
  let fixture: ComponentFixture<EscolhePeriodoCorrenteExperimentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolhePeriodoCorrenteExperimentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolhePeriodoCorrenteExperimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
