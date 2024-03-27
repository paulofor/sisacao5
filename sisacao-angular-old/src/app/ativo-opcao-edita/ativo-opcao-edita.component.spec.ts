import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoOpcaoEditaComponent } from './ativo-opcao-edita.component';

describe('AtivoOpcaoEditaComponent', () => {
  let component: AtivoOpcaoEditaComponent;
  let fixture: ComponentFixture<AtivoOpcaoEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoOpcaoEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoOpcaoEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
