import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataSetAtributoListComponent } from './data-set-atributo-list.component';

describe('DataSetAtributoListComponent', () => {
  let component: DataSetAtributoListComponent;
  let fixture: ComponentFixture<DataSetAtributoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataSetAtributoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataSetAtributoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
