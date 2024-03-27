import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExemploIntradayResultadoAcaoComponent } from './exemplo-intraday-resultado-acao.component';

describe('ExemploIntradayResultadoAcaoComponent', () => {
  let component: ExemploIntradayResultadoAcaoComponent;
  let fixture: ComponentFixture<ExemploIntradayResultadoAcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExemploIntradayResultadoAcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExemploIntradayResultadoAcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
