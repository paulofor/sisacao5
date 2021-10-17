import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoIndiceEditaComponent } from './ativo-indice-edita.component';

describe('AtivoIndiceEditaComponent', () => {
  let component: AtivoIndiceEditaComponent;
  let fixture: ComponentFixture<AtivoIndiceEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoIndiceEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoIndiceEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
