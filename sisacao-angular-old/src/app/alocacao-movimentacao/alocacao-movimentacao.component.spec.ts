import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlocacaoMovimentacaoComponent } from './alocacao-movimentacao.component';

describe('AlocacaoMovimentacaoComponent', () => {
  let component: AlocacaoMovimentacaoComponent;
  let fixture: ComponentFixture<AlocacaoMovimentacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlocacaoMovimentacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlocacaoMovimentacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
