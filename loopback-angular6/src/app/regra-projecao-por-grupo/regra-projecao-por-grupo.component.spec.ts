import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegraProjecaoPorGrupoComponent } from './regra-projecao-por-grupo.component';

describe('RegraProjecaoPorGrupoComponent', () => {
  let component: RegraProjecaoPorGrupoComponent;
  let fixture: ComponentFixture<RegraProjecaoPorGrupoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegraProjecaoPorGrupoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegraProjecaoPorGrupoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
