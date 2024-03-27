import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoAcaoEditaComponent } from './ativo-acao-edita.component';

describe('AtivoAcaoEditaComponent', () => {
  let component: AtivoAcaoEditaComponent;
  let fixture: ComponentFixture<AtivoAcaoEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoAcaoEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoAcaoEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
