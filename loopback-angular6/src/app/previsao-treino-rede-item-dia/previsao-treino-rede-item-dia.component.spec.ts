import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevisaoTreinoRedeItemDiaComponent } from './previsao-treino-rede-item-dia.component';

describe('PrevisaoTreinoRedeItemDiaComponent', () => {
  let component: PrevisaoTreinoRedeItemDiaComponent;
  let fixture: ComponentFixture<PrevisaoTreinoRedeItemDiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrevisaoTreinoRedeItemDiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrevisaoTreinoRedeItemDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
