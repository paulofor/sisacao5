import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntraImobiliarioComponent } from './cotacao-intra-imobiliario.component';

describe('CotacaoIntraImobiliarioComponent', () => {
  let component: CotacaoIntraImobiliarioComponent;
  let fixture: ComponentFixture<CotacaoIntraImobiliarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntraImobiliarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntraImobiliarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
