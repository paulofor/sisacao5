import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GraficoEvolucaoMensalPatrimonioComponent } from './grafico-evolucao-mensal-patrimonio.component';

describe('GraficoEvolucaoMensalPatrimonioComponent', () => {
  let component: GraficoEvolucaoMensalPatrimonioComponent;
  let fixture: ComponentFixture<GraficoEvolucaoMensalPatrimonioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GraficoEvolucaoMensalPatrimonioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GraficoEvolucaoMensalPatrimonioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
