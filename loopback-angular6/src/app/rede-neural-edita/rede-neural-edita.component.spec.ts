import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RedeNeuralEditaComponent } from './rede-neural-edita.component';

describe('RedeNeuralEditaComponent', () => {
  let component: RedeNeuralEditaComponent;
  let fixture: ComponentFixture<RedeNeuralEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RedeNeuralEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RedeNeuralEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
