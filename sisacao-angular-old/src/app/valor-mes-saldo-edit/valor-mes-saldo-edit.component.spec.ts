import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorMesSaldoEditComponent } from './valor-mes-saldo-edit.component';

describe('ValorMesSaldoEditComponent', () => {
  let component: ValorMesSaldoEditComponent;
  let fixture: ComponentFixture<ValorMesSaldoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValorMesSaldoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValorMesSaldoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
