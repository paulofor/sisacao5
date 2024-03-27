import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreinoGrupoListaComponent } from './treino-grupo-lista.component';

describe('TreinoGrupoListaComponent', () => {
  let component: TreinoGrupoListaComponent;
  let fixture: ComponentFixture<TreinoGrupoListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreinoGrupoListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreinoGrupoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
