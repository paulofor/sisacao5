import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdemCompraEditaComponent } from './ordem-compra-edita.component';

describe('OrdemCompraEditaComponent', () => {
  let component: OrdemCompraEditaComponent;
  let fixture: ComponentFixture<OrdemCompraEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdemCompraEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdemCompraEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
