import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoRegraListaComponent } from './grupo-regra-lista.component';

describe('GrupoRegraListaComponent', () => {
  let component: GrupoRegraListaComponent;
  let fixture: ComponentFixture<GrupoRegraListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoRegraListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoRegraListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
