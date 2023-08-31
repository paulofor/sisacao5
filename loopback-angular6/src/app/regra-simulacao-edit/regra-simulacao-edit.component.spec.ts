import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegraSimulacaoEditComponent } from './regra-simulacao-edit.component';

describe('RegraSimulacaoEditComponent', () => {
  let component: RegraSimulacaoEditComponent;
  let fixture: ComponentFixture<RegraSimulacaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegraSimulacaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegraSimulacaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
