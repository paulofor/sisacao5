import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatrimonioEvolucaoMensalComponent } from './patrimonio-evolucao-mensal.component';

describe('PatrimonioEvolucaoMensalComponent', () => {
  let component: PatrimonioEvolucaoMensalComponent;
  let fixture: ComponentFixture<PatrimonioEvolucaoMensalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatrimonioEvolucaoMensalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatrimonioEvolucaoMensalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
