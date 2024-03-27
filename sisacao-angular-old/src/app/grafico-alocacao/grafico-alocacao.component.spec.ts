import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GraficoAlocacaoComponent } from './grafico-alocacao.component';

describe('GraficoAlocacaoComponent', () => {
  let component: GraficoAlocacaoComponent;
  let fixture: ComponentFixture<GraficoAlocacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GraficoAlocacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GraficoAlocacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
