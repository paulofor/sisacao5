import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EscolheRedeGrupoEditComponent } from './escolhe-rede-grupo-edit.component';

describe('EscolheRedeGrupoEditComponent', () => {
  let component: EscolheRedeGrupoEditComponent;
  let fixture: ComponentFixture<EscolheRedeGrupoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EscolheRedeGrupoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EscolheRedeGrupoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
