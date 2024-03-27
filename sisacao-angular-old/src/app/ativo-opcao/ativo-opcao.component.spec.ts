import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoOpcaoComponent } from './ativo-opcao.component';

describe('AtivoOpcaoComponent', () => {
  let component: AtivoOpcaoComponent;
  let fixture: ComponentFixture<AtivoOpcaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoOpcaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoOpcaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
