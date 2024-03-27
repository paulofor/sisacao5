import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoAcaoComponent } from './ativo-acao.component';

describe('AtivoAcaoComponent', () => {
  let component: AtivoAcaoComponent;
  let fixture: ComponentFixture<AtivoAcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoAcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoAcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
