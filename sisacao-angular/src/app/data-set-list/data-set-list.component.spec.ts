import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataSetListComponent } from './data-set-list.component';

describe('DataSetListComponent', () => {
  let component: DataSetListComponent;
  let fixture: ComponentFixture<DataSetListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataSetListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataSetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
