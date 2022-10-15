import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndicadorRedeResumoComponent } from './indicador-rede-resumo.component';

describe('IndicadorRedeResumoComponent', () => {
  let component: IndicadorRedeResumoComponent;
  let fixture: ComponentFixture<IndicadorRedeResumoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndicadorRedeResumoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndicadorRedeResumoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
