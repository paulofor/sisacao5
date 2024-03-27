import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdemCompraListaComponent } from './ordem-compra-lista.component';

describe('OrdemCompraListaComponent', () => {
  let component: OrdemCompraListaComponent;
  let fixture: ComponentFixture<OrdemCompraListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdemCompraListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdemCompraListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
