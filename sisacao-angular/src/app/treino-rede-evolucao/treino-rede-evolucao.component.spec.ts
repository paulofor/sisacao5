import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreinoRedeEvolucaoComponent } from './treino-rede-evolucao.component';

describe('TreinoRedeEvolucaoComponent', () => {
  let component: TreinoRedeEvolucaoComponent;
  let fixture: ComponentFixture<TreinoRedeEvolucaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreinoRedeEvolucaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreinoRedeEvolucaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
