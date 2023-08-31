import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreinoRedeEditaComponent } from './treino-rede-edita.component';

describe('TreinoRedeEditaComponent', () => {
  let component: TreinoRedeEditaComponent;
  let fixture: ComponentFixture<TreinoRedeEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreinoRedeEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreinoRedeEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
