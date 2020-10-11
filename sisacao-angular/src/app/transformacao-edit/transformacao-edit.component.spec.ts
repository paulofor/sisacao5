import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransformacaoEditComponent } from './transformacao-edit.component';

describe('TransformacaoEditComponent', () => {
  let component: TransformacaoEditComponent;
  let fixture: ComponentFixture<TransformacaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransformacaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransformacaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
