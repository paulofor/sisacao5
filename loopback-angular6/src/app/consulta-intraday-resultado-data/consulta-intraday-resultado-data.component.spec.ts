import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaIntradayResultadoDataComponent } from './consulta-intraday-resultado-data.component';

describe('ConsultaIntradayResultadoDataComponent', () => {
  let component: ConsultaIntradayResultadoDataComponent;
  let fixture: ComponentFixture<ConsultaIntradayResultadoDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaIntradayResultadoDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaIntradayResultadoDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
