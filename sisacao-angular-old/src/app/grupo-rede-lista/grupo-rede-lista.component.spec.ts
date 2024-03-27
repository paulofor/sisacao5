import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoRedeListaComponent } from './grupo-rede-lista.component';

describe('GrupoRedeListaComponent', () => {
  let component: GrupoRedeListaComponent;
  let fixture: ComponentFixture<GrupoRedeListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoRedeListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoRedeListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
