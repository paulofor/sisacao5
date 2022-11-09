import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanoMensalComponent } from './plano-mensal.component';

describe('PlanoMensalComponent', () => {
  let component: PlanoMensalComponent;
  let fixture: ComponentFixture<PlanoMensalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanoMensalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanoMensalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
