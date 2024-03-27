import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeRealListaEditComponent } from './trade-real-lista-edit.component';

describe('TradeRealListaEditComponent', () => {
  let component: TradeRealListaEditComponent;
  let fixture: ComponentFixture<TradeRealListaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TradeRealListaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TradeRealListaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
