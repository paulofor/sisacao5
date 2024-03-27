import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoIndiceComponent } from './ativo-indice.component';

describe('AtivoIndiceComponent', () => {
  let component: AtivoIndiceComponent;
  let fixture: ComponentFixture<AtivoIndiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoIndiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoIndiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
