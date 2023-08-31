import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceiroFixoAcaoComponent } from './financeiro-fixo-acao.component';

describe('FinanceiroFixoAcaoComponent', () => {
  let component: FinanceiroFixoAcaoComponent;
  let fixture: ComponentFixture<FinanceiroFixoAcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceiroFixoAcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceiroFixoAcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
