import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataSetAtributoEditComponent } from './data-set-atributo-edit.component';

describe('DataSetAtributoEditComponent', () => {
  let component: DataSetAtributoEditComponent;
  let fixture: ComponentFixture<DataSetAtributoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataSetAtributoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataSetAtributoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
