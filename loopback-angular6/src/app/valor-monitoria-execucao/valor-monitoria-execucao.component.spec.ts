import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorMonitoriaExecucaoComponent } from './valor-monitoria-execucao.component';

describe('ValorMonitoriaExecucaoComponent', () => {
  let component: ValorMonitoriaExecucaoComponent;
  let fixture: ComponentFixture<ValorMonitoriaExecucaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValorMonitoriaExecucaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValorMonitoriaExecucaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
