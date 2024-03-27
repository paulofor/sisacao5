import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeAtivoComponent } from './trade-ativo.component';

describe('TradeAtivoComponent', () => {
  let component: TradeAtivoComponent;
  let fixture: ComponentFixture<TradeAtivoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeAtivoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeAtivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
