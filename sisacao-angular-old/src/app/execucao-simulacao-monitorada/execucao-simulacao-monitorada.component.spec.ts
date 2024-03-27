import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecucaoSimulacaoMonitoradaComponent } from './execucao-simulacao-monitorada.component';

describe('ExecucaoSimulacaoMonitoradaComponent', () => {
  let component: ExecucaoSimulacaoMonitoradaComponent;
  let fixture: ComponentFixture<ExecucaoSimulacaoMonitoradaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExecucaoSimulacaoMonitoradaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecucaoSimulacaoMonitoradaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
