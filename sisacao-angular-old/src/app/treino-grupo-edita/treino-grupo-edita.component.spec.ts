import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreinoGrupoEditaComponent } from './treino-grupo-edita.component';

describe('TreinoGrupoEditaComponent', () => {
  let component: TreinoGrupoEditaComponent;
  let fixture: ComponentFixture<TreinoGrupoEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreinoGrupoEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreinoGrupoEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
