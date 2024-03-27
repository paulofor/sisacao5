import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolheAcaoGrupoEditComponent } from './escolhe-acao-grupo-edit.component';

describe('EscolheAcaoGrupoEditComponent', () => {
  let component: EscolheAcaoGrupoEditComponent;
  let fixture: ComponentFixture<EscolheAcaoGrupoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolheAcaoGrupoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolheAcaoGrupoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
