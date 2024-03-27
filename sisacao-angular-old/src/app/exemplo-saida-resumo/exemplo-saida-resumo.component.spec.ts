import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExemploSaidaResumoComponent } from './exemplo-saida-resumo.component';

describe('ExemploSaidaResumoComponent', () => {
  let component: ExemploSaidaResumoComponent;
  let fixture: ComponentFixture<ExemploSaidaResumoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExemploSaidaResumoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExemploSaidaResumoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
