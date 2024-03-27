import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemVisualIndiceComponent } from './item-visual-indice.component';

describe('ItemVisualIndiceComponent', () => {
  let component: ItemVisualIndiceComponent;
  let fixture: ComponentFixture<ItemVisualIndiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemVisualIndiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemVisualIndiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
