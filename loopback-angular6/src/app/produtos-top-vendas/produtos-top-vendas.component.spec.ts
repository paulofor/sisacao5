import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutosTopVendasComponent } from './produtos-top-vendas.component';

describe('ProdutosTopVendasComponent', () => {
  let component: ProdutosTopVendasComponent;
  let fixture: ComponentFixture<ProdutosTopVendasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProdutosTopVendasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProdutosTopVendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
