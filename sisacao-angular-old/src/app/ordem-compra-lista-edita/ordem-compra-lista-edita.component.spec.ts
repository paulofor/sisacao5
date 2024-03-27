import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdemCompraListaEditaComponent } from './ordem-compra-lista-edita.component';

describe('OrdemCompraListaEditaComponent', () => {
  let component: OrdemCompraListaEditaComponent;
  let fixture: ComponentFixture<OrdemCompraListaEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdemCompraListaEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdemCompraListaEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
