import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobiliarioMelhoresRendimentoComponent } from './fundo-imobiliario-melhores-rendimento.component';

describe('FundoImobiliarioMelhoresRendimentoComponent', () => {
  let component: FundoImobiliarioMelhoresRendimentoComponent;
  let fixture: ComponentFixture<FundoImobiliarioMelhoresRendimentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobiliarioMelhoresRendimentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobiliarioMelhoresRendimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
