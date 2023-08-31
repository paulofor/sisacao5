import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoExemploTreinoListComponent } from './tipo-exemplo-treino-list.component';

describe('TipoExemploTreinoListComponent', () => {
  let component: TipoExemploTreinoListComponent;
  let fixture: ComponentFixture<TipoExemploTreinoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipoExemploTreinoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoExemploTreinoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
