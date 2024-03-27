import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorMesSaldoListComponent } from './valor-mes-saldo-list.component';

describe('ValorMesSaldoListComponent', () => {
  let component: ValorMesSaldoListComponent;
  let fixture: ComponentFixture<ValorMesSaldoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValorMesSaldoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValorMesSaldoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
