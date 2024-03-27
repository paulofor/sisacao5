import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevisaoHistoricoComponent } from './previsao-historico.component';

describe('PrevisaoHistoricoComponent', () => {
  let component: PrevisaoHistoricoComponent;
  let fixture: ComponentFixture<PrevisaoHistoricoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrevisaoHistoricoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrevisaoHistoricoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
