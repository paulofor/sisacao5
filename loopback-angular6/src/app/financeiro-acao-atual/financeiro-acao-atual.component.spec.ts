import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceiroAcaoAtualComponent } from './financeiro-acao-atual.component';

describe('FinanceiroAcaoAtualComponent', () => {
  let component: FinanceiroAcaoAtualComponent;
  let fixture: ComponentFixture<FinanceiroAcaoAtualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceiroAcaoAtualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceiroAcaoAtualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
