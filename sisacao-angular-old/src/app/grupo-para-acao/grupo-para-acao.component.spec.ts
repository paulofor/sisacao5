import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoParaAcaoComponent } from './grupo-para-acao.component';

describe('GrupoParaAcaoComponent', () => {
  let component: GrupoParaAcaoComponent;
  let fixture: ComponentFixture<GrupoParaAcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoParaAcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoParaAcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
