import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PeriodoExperimentoEditaComponent } from './periodo-experimento-edita.component';

describe('PeriodoExperimentoEditaComponent', () => {
  let component: PeriodoExperimentoEditaComponent;
  let fixture: ComponentFixture<PeriodoExperimentoEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PeriodoExperimentoEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PeriodoExperimentoEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
