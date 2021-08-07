import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheAluguelFundoImobiliarioComponent } from './detalhe-aluguel-fundo-imobiliario.component';

describe('DetalheAluguelFundoImobiliarioComponent', () => {
  let component: DetalheAluguelFundoImobiliarioComponent;
  let fixture: ComponentFixture<DetalheAluguelFundoImobiliarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalheAluguelFundoImobiliarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalheAluguelFundoImobiliarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
