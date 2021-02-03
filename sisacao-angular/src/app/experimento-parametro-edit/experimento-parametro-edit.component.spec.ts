import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperimentoParametroEditComponent } from './experimento-parametro-edit.component';

describe('ExperimentoParametroEditComponent', () => {
  let component: ExperimentoParametroEditComponent;
  let fixture: ComponentFixture<ExperimentoParametroEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExperimentoParametroEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExperimentoParametroEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
