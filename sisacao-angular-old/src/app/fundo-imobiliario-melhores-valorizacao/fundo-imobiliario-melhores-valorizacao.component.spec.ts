import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobiliarioMelhoresValorizacaoComponent } from './fundo-imobiliario-melhores-valorizacao.component';

describe('FundoImobiliarioMelhoresValorizacaoComponent', () => {
  let component: FundoImobiliarioMelhoresValorizacaoComponent;
  let fixture: ComponentFixture<FundoImobiliarioMelhoresValorizacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobiliarioMelhoresValorizacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobiliarioMelhoresValorizacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
