import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FechamentoRegraDiaListComponent } from './fechamento-regra-dia-list.component';

describe('FechamentoRegraDiaListComponent', () => {
  let component: FechamentoRegraDiaListComponent;
  let fixture: ComponentFixture<FechamentoRegraDiaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FechamentoRegraDiaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FechamentoRegraDiaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
