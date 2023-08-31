import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaldoCorrenteFixoEditComponent } from './saldo-corrente-fixo-edit.component';

describe('SaldoCorrenteFixoEditComponent', () => {
  let component: SaldoCorrenteFixoEditComponent;
  let fixture: ComponentFixture<SaldoCorrenteFixoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaldoCorrenteFixoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaldoCorrenteFixoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
