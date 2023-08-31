import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntraMercadoriaComponent } from './cotacao-intra-mercadoria.component';

describe('CotacaoIntraMercadoriaComponent', () => {
  let component: CotacaoIntraMercadoriaComponent;
  let fixture: ComponentFixture<CotacaoIntraMercadoriaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntraMercadoriaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntraMercadoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
