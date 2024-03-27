import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MapaCalorGrupoTreinoComponent } from './mapa-calor-grupo-treino.component';

describe('MapaCalorGrupoTreinoComponent', () => {
  let component: MapaCalorGrupoTreinoComponent;
  let fixture: ComponentFixture<MapaCalorGrupoTreinoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MapaCalorGrupoTreinoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MapaCalorGrupoTreinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
