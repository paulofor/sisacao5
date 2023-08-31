import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolheRegraGrupoEditComponent } from './escolhe-regra-grupo-edit.component';

describe('EscolheRegraGrupoEditComponent', () => {
  let component: EscolheRegraGrupoEditComponent;
  let fixture: ComponentFixture<EscolheRegraGrupoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolheRegraGrupoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolheRegraGrupoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
