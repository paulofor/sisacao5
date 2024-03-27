import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RedeNeuralListaComponent } from './rede-neural-lista.component';

describe('RedeNeuralListaComponent', () => {
  let component: RedeNeuralListaComponent;
  let fixture: ComponentFixture<RedeNeuralListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RedeNeuralListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RedeNeuralListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
