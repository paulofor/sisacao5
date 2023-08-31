import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PeriodoTreinoRedeListaComponent } from './periodo-treino-rede-lista.component';

describe('PeriodoTreinoRedeListaComponent', () => {
  let component: PeriodoTreinoRedeListaComponent;
  let fixture: ComponentFixture<PeriodoTreinoRedeListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PeriodoTreinoRedeListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PeriodoTreinoRedeListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
