import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PeriodoExperimentoListaComponent } from './periodo-experimento-lista.component';

describe('PeriodoExperimentoListaComponent', () => {
  let component: PeriodoExperimentoListaComponent;
  let fixture: ComponentFixture<PeriodoExperimentoListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PeriodoExperimentoListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PeriodoExperimentoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
