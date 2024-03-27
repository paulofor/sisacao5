import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobiliarioCarteiraComponent } from './fundo-imobiliario-carteira.component';

describe('FundoImobiliarioCarteiraComponent', () => {
  let component: FundoImobiliarioCarteiraComponent;
  let fixture: ComponentFixture<FundoImobiliarioCarteiraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobiliarioCarteiraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobiliarioCarteiraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
