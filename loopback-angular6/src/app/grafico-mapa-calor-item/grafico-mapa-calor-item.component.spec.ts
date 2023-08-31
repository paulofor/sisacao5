import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GraficoMapaCalorItemComponent } from './grafico-mapa-calor-item.component';

describe('GraficoMapaCalorItemComponent', () => {
  let component: GraficoMapaCalorItemComponent;
  let fixture: ComponentFixture<GraficoMapaCalorItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GraficoMapaCalorItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GraficoMapaCalorItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
