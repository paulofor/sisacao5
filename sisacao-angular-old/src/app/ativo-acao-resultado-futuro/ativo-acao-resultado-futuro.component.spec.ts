import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoAcaoResultadoFuturoComponent } from './ativo-acao-resultado-futuro.component';

describe('AtivoAcaoResultadoFuturoComponent', () => {
  let component: AtivoAcaoResultadoFuturoComponent;
  let fixture: ComponentFixture<AtivoAcaoResultadoFuturoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoAcaoResultadoFuturoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoAcaoResultadoFuturoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
