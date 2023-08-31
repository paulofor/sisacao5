import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoAcaoListComponent } from './grupo-acao-list.component';

describe('GrupoAcaoListComponent', () => {
  let component: GrupoAcaoListComponent;
  let fixture: ComponentFixture<GrupoAcaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoAcaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoAcaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
