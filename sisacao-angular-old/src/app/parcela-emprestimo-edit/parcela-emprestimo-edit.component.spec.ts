import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParcelaEmprestimoEditComponent } from './parcela-emprestimo-edit.component';

describe('ParcelaEmprestimoEditComponent', () => {
  let component: ParcelaEmprestimoEditComponent;
  let fixture: ComponentFixture<ParcelaEmprestimoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParcelaEmprestimoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParcelaEmprestimoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
