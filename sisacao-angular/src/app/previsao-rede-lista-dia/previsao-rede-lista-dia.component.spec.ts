import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevisaoRedeListaDiaComponent } from './previsao-rede-lista-dia.component';

describe('PrevisaoRedeListaDiaComponent', () => {
  let component: PrevisaoRedeListaDiaComponent;
  let fixture: ComponentFixture<PrevisaoRedeListaDiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrevisaoRedeListaDiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrevisaoRedeListaDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
