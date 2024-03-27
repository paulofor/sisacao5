import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegraSimulacaoListComponent } from './regra-simulacao-list.component';

describe('RegraSimulacaoListComponent', () => {
  let component: RegraSimulacaoListComponent;
  let fixture: ComponentFixture<RegraSimulacaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegraSimulacaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegraSimulacaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
