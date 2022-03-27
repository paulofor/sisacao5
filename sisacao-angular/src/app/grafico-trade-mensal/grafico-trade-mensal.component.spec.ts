import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GraficoTradeMensalComponent } from './grafico-trade-mensal.component';

describe('GraficoTradeMensalComponent', () => {
  let component: GraficoTradeMensalComponent;
  let fixture: ComponentFixture<GraficoTradeMensalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GraficoTradeMensalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GraficoTradeMensalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
