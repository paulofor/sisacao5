import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorMonitoriaPeriodoComponent } from './valor-monitoria-periodo.component';

describe('ValorMonitoriaPeriodoComponent', () => {
  let component: ValorMonitoriaPeriodoComponent;
  let fixture: ComponentFixture<ValorMonitoriaPeriodoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValorMonitoriaPeriodoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValorMonitoriaPeriodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
