import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmprestimoP2PListaComponent } from './emprestimo-p2-plista.component';

describe('EmprestimoP2PListaComponent', () => {
  let component: EmprestimoP2PListaComponent;
  let fixture: ComponentFixture<EmprestimoP2PListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmprestimoP2PListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmprestimoP2PListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
