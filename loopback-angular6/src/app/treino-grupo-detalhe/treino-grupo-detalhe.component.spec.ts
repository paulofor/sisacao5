import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreinoGrupoDetalheComponent } from './treino-grupo-detalhe.component';

describe('TreinoGrupoDetalheComponent', () => {
  let component: TreinoGrupoDetalheComponent;
  let fixture: ComponentFixture<TreinoGrupoDetalheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreinoGrupoDetalheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreinoGrupoDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
