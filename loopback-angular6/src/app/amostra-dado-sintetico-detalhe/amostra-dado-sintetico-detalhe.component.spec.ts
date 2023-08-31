import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AmostraDadoSinteticoDetalheComponent } from './amostra-dado-sintetico-detalhe.component';

describe('AmostraDadoSinteticoDetalheComponent', () => {
  let component: AmostraDadoSinteticoDetalheComponent;
  let fixture: ComponentFixture<AmostraDadoSinteticoDetalheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AmostraDadoSinteticoDetalheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AmostraDadoSinteticoDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
