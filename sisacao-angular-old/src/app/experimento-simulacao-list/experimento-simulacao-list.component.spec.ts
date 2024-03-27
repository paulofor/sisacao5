import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperimentoSimulacaoListComponent } from './experimento-simulacao-list.component';

describe('ExperimentoSimulacaoListComponent', () => {
  let component: ExperimentoSimulacaoListComponent;
  let fixture: ComponentFixture<ExperimentoSimulacaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExperimentoSimulacaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExperimentoSimulacaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
