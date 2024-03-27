import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoRegraDetalheComponent } from './grupo-regra-detalhe.component';

describe('GrupoRegraDetalheComponent', () => {
  let component: GrupoRegraDetalheComponent;
  let fixture: ComponentFixture<GrupoRegraDetalheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoRegraDetalheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoRegraDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
