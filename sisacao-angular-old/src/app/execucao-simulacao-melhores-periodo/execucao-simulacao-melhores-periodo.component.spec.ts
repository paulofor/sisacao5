import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecucaoSimulacaoMelhoresPeriodoComponent } from './execucao-simulacao-melhores-periodo.component';

describe('ExecucaoSimulacaoMelhoresPeriodoComponent', () => {
  let component: ExecucaoSimulacaoMelhoresPeriodoComponent;
  let fixture: ComponentFixture<ExecucaoSimulacaoMelhoresPeriodoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExecucaoSimulacaoMelhoresPeriodoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecucaoSimulacaoMelhoresPeriodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
