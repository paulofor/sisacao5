import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PeriodoTreinoRedeEditaComponent } from './periodo-treino-rede-edita.component';

describe('PeriodoTreinoRedeEditaComponent', () => {
  let component: PeriodoTreinoRedeEditaComponent;
  let fixture: ComponentFixture<PeriodoTreinoRedeEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PeriodoTreinoRedeEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PeriodoTreinoRedeEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
