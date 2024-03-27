import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MelhoresValidacaoPeriodoComponent } from './melhores-validacao-periodo.component';

describe('MelhoresValidacaoPeriodoComponent', () => {
  let component: MelhoresValidacaoPeriodoComponent;
  let fixture: ComponentFixture<MelhoresValidacaoPeriodoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MelhoresValidacaoPeriodoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MelhoresValidacaoPeriodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
