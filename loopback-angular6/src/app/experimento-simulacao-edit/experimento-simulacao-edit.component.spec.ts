import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperimentoSimulacaoEditComponent } from './experimento-simulacao-edit.component';

describe('ExperimentoSimulacaoEditComponent', () => {
  let component: ExperimentoSimulacaoEditComponent;
  let fixture: ComponentFixture<ExperimentoSimulacaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExperimentoSimulacaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExperimentoSimulacaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
