import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoIntradayRecenteComponent } from './cotacao-intraday-recente.component';

describe('CotacaoIntradayRecenteComponent', () => {
  let component: CotacaoIntradayRecenteComponent;
  let fixture: ComponentFixture<CotacaoIntradayRecenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotacaoIntradayRecenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotacaoIntradayRecenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
