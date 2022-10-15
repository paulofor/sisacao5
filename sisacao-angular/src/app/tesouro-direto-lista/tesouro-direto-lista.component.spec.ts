import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TesouroDiretoListaComponent } from './tesouro-direto-lista.component';

describe('TesouroDiretoListaComponent', () => {
  let component: TesouroDiretoListaComponent;
  let fixture: ComponentFixture<TesouroDiretoListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TesouroDiretoListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TesouroDiretoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
