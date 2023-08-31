import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoImobiliarioEditaComponent } from './ativo-imobiliario-edita.component';

describe('AtivoImobiliarioEditaComponent', () => {
  let component: AtivoImobiliarioEditaComponent;
  let fixture: ComponentFixture<AtivoImobiliarioEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoImobiliarioEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoImobiliarioEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
