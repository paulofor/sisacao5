import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanoMensalEditaComponent } from './plano-mensal-edita.component';

describe('PlanoMensalEditaComponent', () => {
  let component: PlanoMensalEditaComponent;
  let fixture: ComponentFixture<PlanoMensalEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanoMensalEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanoMensalEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
