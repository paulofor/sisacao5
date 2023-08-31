import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImobiliarioGeralComponent } from './imobiliario-geral.component';

describe('ImobiliarioGeralComponent', () => {
  let component: ImobiliarioGeralComponent;
  let fixture: ComponentFixture<ImobiliarioGeralComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImobiliarioGeralComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImobiliarioGeralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
