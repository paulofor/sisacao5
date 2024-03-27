import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataSetCreateSqlComponent } from './data-set-create-sql.component';

describe('DataSetCreateSqlComponent', () => {
  let component: DataSetCreateSqlComponent;
  let fixture: ComponentFixture<DataSetCreateSqlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataSetCreateSqlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataSetCreateSqlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
