import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResumoTradeRealComponent } from './resumo-trade-real.component';

describe('ResumoTradeRealComponent', () => {
  let component: ResumoTradeRealComponent;
  let fixture: ComponentFixture<ResumoTradeRealComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResumoTradeRealComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResumoTradeRealComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
