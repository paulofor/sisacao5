import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AmostraDadoSinteticoListComponent } from './amostra-dado-sintetico-list.component';

describe('AmostraDadoSinteticoListComponent', () => {
  let component: AmostraDadoSinteticoListComponent;
  let fixture: ComponentFixture<AmostraDadoSinteticoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AmostraDadoSinteticoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AmostraDadoSinteticoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
