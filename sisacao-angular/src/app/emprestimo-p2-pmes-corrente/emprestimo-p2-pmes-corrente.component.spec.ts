import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmprestimoP2PMesCorrenteComponent } from './emprestimo-p2-pmes-corrente.component';

describe('EmprestimoP2PMesCorrenteComponent', () => {
  let component: EmprestimoP2PMesCorrenteComponent;
  let fixture: ComponentFixture<EmprestimoP2PMesCorrenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmprestimoP2PMesCorrenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmprestimoP2PMesCorrenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
