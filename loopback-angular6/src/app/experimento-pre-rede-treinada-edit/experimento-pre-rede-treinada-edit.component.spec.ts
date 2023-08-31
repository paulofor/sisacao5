import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperimentoPreRedeTreinadaEditComponent } from './experimento-pre-rede-treinada-edit.component';

describe('ExperimentoPreRedeTreinadaEditComponent', () => {
  let component: ExperimentoPreRedeTreinadaEditComponent;
  let fixture: ComponentFixture<ExperimentoPreRedeTreinadaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExperimentoPreRedeTreinadaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExperimentoPreRedeTreinadaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
