import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreinoRedeListaComponent } from './treino-rede-lista.component';

describe('TreinoRedeListaComponent', () => {
  let component: TreinoRedeListaComponent;
  let fixture: ComponentFixture<TreinoRedeListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreinoRedeListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreinoRedeListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
