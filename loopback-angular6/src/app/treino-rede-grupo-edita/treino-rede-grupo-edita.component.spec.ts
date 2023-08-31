import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreinoRedeGrupoEditaComponent } from './treino-rede-grupo-edita.component';

describe('TreinoRedeGrupoEditaComponent', () => {
  let component: TreinoRedeGrupoEditaComponent;
  let fixture: ComponentFixture<TreinoRedeGrupoEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreinoRedeGrupoEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreinoRedeGrupoEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
