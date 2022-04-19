import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobiliarioMelhorEstabilidadeComponent } from './fundo-imobiliario-melhor-estabilidade.component';

describe('FundoImobiliarioMelhorEstabilidadeComponent', () => {
  let component: FundoImobiliarioMelhorEstabilidadeComponent;
  let fixture: ComponentFixture<FundoImobiliarioMelhorEstabilidadeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobiliarioMelhorEstabilidadeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobiliarioMelhorEstabilidadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
