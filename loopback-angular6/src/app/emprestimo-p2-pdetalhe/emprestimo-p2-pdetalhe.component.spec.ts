import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmprestimoP2PDetalheComponent } from './emprestimo-p2-pdetalhe.component';

describe('EmprestimoP2PDetalheComponent', () => {
  let component: EmprestimoP2PDetalheComponent;
  let fixture: ComponentFixture<EmprestimoP2PDetalheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmprestimoP2PDetalheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmprestimoP2PDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
