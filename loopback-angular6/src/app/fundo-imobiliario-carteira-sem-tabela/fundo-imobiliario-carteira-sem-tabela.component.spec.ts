import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobiliarioCarteiraSemTabelaComponent } from './fundo-imobiliario-carteira-sem-tabela.component';

describe('FundoImobiliarioCarteiraSemTabelaComponent', () => {
  let component: FundoImobiliarioCarteiraSemTabelaComponent;
  let fixture: ComponentFixture<FundoImobiliarioCarteiraSemTabelaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobiliarioCarteiraSemTabelaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobiliarioCarteiraSemTabelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
