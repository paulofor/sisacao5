import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntraCriptomoedaComponent } from './cotacao-intra-criptomoeda.component';

describe('CotacaoIntraCriptomoedaComponent', () => {
  let component: CotacaoIntraCriptomoedaComponent;
  let fixture: ComponentFixture<CotacaoIntraCriptomoedaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntraCriptomoedaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntraCriptomoedaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
