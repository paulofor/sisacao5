import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidadorExemploSaidaComponent } from './validador-exemplo-saida.component';

describe('ValidadorExemploSaidaComponent', () => {
  let component: ValidadorExemploSaidaComponent;
  let fixture: ComponentFixture<ValidadorExemploSaidaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValidadorExemploSaidaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValidadorExemploSaidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
