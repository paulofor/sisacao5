import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemTradeRealVisualComponent } from './item-trade-real-visual.component';

describe('ItemTradeRealVisualComponent', () => {
  let component: ItemTradeRealVisualComponent;
  let fixture: ComponentFixture<ItemTradeRealVisualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemTradeRealVisualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemTradeRealVisualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
