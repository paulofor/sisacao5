import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecucaoSimulacaoMelhoresResultadoComponent } from './execucao-simulacao-melhores-resultado.component';

describe('ExecucaoSimulacaoMelhoresResultadoComponent', () => {
  let component: ExecucaoSimulacaoMelhoresResultadoComponent;
  let fixture: ComponentFixture<ExecucaoSimulacaoMelhoresResultadoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExecucaoSimulacaoMelhoresResultadoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecucaoSimulacaoMelhoresResultadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
