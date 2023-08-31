import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExemploEntradaListaComponent } from './exemplo-entrada-lista.component';

describe('ExemploEntradaListaComponent', () => {
  let component: ExemploEntradaListaComponent;
  let fixture: ComponentFixture<ExemploEntradaListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExemploEntradaListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExemploEntradaListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
