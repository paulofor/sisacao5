import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResumoTradeReal2Component } from './resumo-trade-real2.component';

describe('ResumoTradeReal2Component', () => {
  let component: ResumoTradeReal2Component;
  let fixture: ComponentFixture<ResumoTradeReal2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResumoTradeReal2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResumoTradeReal2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
