import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TesouroDiretoCotacaoComponent } from './tesouro-direto-cotacao.component';

describe('TesouroDiretoCotacaoComponent', () => {
  let component: TesouroDiretoCotacaoComponent;
  let fixture: ComponentFixture<TesouroDiretoCotacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TesouroDiretoCotacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TesouroDiretoCotacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
