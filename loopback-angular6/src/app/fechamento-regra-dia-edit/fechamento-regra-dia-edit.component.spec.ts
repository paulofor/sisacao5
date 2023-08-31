import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FechamentoRegraDiaEditComponent } from './fechamento-regra-dia-edit.component';

describe('FechamentoRegraDiaEditComponent', () => {
  let component: FechamentoRegraDiaEditComponent;
  let fixture: ComponentFixture<FechamentoRegraDiaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FechamentoRegraDiaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FechamentoRegraDiaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
