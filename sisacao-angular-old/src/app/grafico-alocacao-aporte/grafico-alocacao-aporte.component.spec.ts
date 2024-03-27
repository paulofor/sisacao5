import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GraficoAlocacaoAporteComponent } from './grafico-alocacao-aporte.component';

describe('GraficoAlocacaoAporteComponent', () => {
  let component: GraficoAlocacaoAporteComponent;
  let fixture: ComponentFixture<GraficoAlocacaoAporteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GraficoAlocacaoAporteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GraficoAlocacaoAporteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
