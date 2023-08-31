import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegraProjecaoOrdenadaDataComponent } from './regra-projecao-ordenada-data.component';

describe('RegraProjecaoOrdenadaDataComponent', () => {
  let component: RegraProjecaoOrdenadaDataComponent;
  let fixture: ComponentFixture<RegraProjecaoOrdenadaDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegraProjecaoOrdenadaDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegraProjecaoOrdenadaDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
