import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AmostraDadoSinteticoEditComponent } from './amostra-dado-sintetico-edit.component';

describe('AmostraDadoSinteticoEditComponent', () => {
  let component: AmostraDadoSinteticoEditComponent;
  let fixture: ComponentFixture<AmostraDadoSinteticoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AmostraDadoSinteticoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AmostraDadoSinteticoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
