import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtributoDataSetEditComponent } from './atributo-data-set-edit.component';

describe('AtributoDataSetEditComponent', () => {
  let component: AtributoDataSetEditComponent;
  let fixture: ComponentFixture<AtributoDataSetEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtributoDataSetEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtributoDataSetEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
