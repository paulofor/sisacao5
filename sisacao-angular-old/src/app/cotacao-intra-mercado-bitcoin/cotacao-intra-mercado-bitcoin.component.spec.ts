import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntraMercadoBitcoinComponent } from './cotacao-intra-mercado-bitcoin.component';

describe('CotacaoIntraMercadoBitcoinComponent', () => {
  let component: CotacaoIntraMercadoBitcoinComponent;
  let fixture: ComponentFixture<CotacaoIntraMercadoBitcoinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntraMercadoBitcoinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntraMercadoBitcoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
