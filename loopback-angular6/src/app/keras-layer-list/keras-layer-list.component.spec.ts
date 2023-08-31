import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KerasLayerListComponent } from './keras-layer-list.component';

describe('KerasLayerListComponent', () => {
  let component: KerasLayerListComponent;
  let fixture: ComponentFixture<KerasLayerListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KerasLayerListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KerasLayerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
