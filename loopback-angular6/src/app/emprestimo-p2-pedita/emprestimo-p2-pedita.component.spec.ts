import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmprestimoP2PEditaComponent } from './emprestimo-p2-pedita.component';

describe('EmprestimoP2PEditaComponent', () => {
  let component: EmprestimoP2PEditaComponent;
  let fixture: ComponentFixture<EmprestimoP2PEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmprestimoP2PEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmprestimoP2PEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
