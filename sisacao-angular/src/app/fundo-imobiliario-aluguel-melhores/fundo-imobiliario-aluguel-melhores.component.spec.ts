import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobiliarioAluguelMelhoresComponent } from './fundo-imobiliario-aluguel-melhores.component';

describe('FundoImobiliarioAluguelMelhoresComponent', () => {
  let component: FundoImobiliarioAluguelMelhoresComponent;
  let fixture: ComponentFixture<FundoImobiliarioAluguelMelhoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobiliarioAluguelMelhoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobiliarioAluguelMelhoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
