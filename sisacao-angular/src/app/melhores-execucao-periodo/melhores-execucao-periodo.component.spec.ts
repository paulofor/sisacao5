import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MelhoresExecucaoPeriodoComponent } from './melhores-execucao-periodo.component';

describe('MelhoresExecucaoPeriodoComponent', () => {
  let component: MelhoresExecucaoPeriodoComponent;
  let fixture: ComponentFixture<MelhoresExecucaoPeriodoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MelhoresExecucaoPeriodoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MelhoresExecucaoPeriodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
