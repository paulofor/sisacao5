import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RankingTreinoRedeComponent } from './ranking-treino-rede.component';

describe('RankingTreinoRedeComponent', () => {
  let component: RankingTreinoRedeComponent;
  let fixture: ComponentFixture<RankingTreinoRedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RankingTreinoRedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RankingTreinoRedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
