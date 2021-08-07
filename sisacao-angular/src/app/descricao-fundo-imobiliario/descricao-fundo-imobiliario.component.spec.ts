import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DescricaoFundoImobiliarioComponent } from './descricao-fundo-imobiliario.component';

describe('DescricaoFundoImobiliarioComponent', () => {
  let component: DescricaoFundoImobiliarioComponent;
  let fixture: ComponentFixture<DescricaoFundoImobiliarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DescricaoFundoImobiliarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DescricaoFundoImobiliarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
