import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoImobiliarioComponent } from './ativo-imobiliario.component';

describe('AtivoImobiliarioComponent', () => {
  let component: AtivoImobiliarioComponent;
  let fixture: ComponentFixture<AtivoImobiliarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoImobiliarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoImobiliarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
