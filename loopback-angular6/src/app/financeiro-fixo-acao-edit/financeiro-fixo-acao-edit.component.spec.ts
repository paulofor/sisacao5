import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceiroFixoAcaoEditComponent } from './financeiro-fixo-acao-edit.component';

describe('FinanceiroFixoAcaoEditComponent', () => {
  let component: FinanceiroFixoAcaoEditComponent;
  let fixture: ComponentFixture<FinanceiroFixoAcaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceiroFixoAcaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceiroFixoAcaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
