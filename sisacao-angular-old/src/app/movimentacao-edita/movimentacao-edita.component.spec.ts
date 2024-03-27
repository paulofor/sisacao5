import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovimentacaoEditaComponent } from './movimentacao-edita.component';

describe('MovimentacaoEditaComponent', () => {
  let component: MovimentacaoEditaComponent;
  let fixture: ComponentFixture<MovimentacaoEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovimentacaoEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovimentacaoEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
