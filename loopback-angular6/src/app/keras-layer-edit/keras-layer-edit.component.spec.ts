import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KerasLayerEditComponent } from './keras-layer-edit.component';

describe('KerasLayerEditComponent', () => {
  let component: KerasLayerEditComponent;
  let fixture: ComponentFixture<KerasLayerEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KerasLayerEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KerasLayerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
