import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlocacaoMovimentacaoEditaComponent } from './alocacao-movimentacao-edita.component';

describe('AlocacaoMovimentacaoEditaComponent', () => {
  let component: AlocacaoMovimentacaoEditaComponent;
  let fixture: ComponentFixture<AlocacaoMovimentacaoEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlocacaoMovimentacaoEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlocacaoMovimentacaoEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
