import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoAcaoEditComponent } from './grupo-acao-edit.component';

describe('GrupoAcaoEditComponent', () => {
  let component: GrupoAcaoEditComponent;
  let fixture: ComponentFixture<GrupoAcaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoAcaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoAcaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
