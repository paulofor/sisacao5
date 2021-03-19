import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecucaoSimulacaoDisplayComponent } from './execucao-simulacao-display.component';

describe('ExecucaoSimulacaoDisplayComponent', () => {
  let component: ExecucaoSimulacaoDisplayComponent;
  let fixture: ComponentFixture<ExecucaoSimulacaoDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExecucaoSimulacaoDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExecucaoSimulacaoDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
