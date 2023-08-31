import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoExemploTreinoEditComponent } from './tipo-exemplo-treino-edit.component';

describe('TipoExemploTreinoEditComponent', () => {
  let component: TipoExemploTreinoEditComponent;
  let fixture: ComponentFixture<TipoExemploTreinoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipoExemploTreinoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoExemploTreinoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
