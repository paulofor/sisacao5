import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevisaoRedeItemDiaComponent } from './previsao-rede-item-dia.component';

describe('PrevisaoRedeItemDiaComponent', () => {
  let component: PrevisaoRedeItemDiaComponent;
  let fixture: ComponentFixture<PrevisaoRedeItemDiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrevisaoRedeItemDiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrevisaoRedeItemDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
