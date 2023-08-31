import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImobiliarioIntradayComponent } from './imobiliario-intraday.component';

describe('ImobiliarioIntradayComponent', () => {
  let component: ImobiliarioIntradayComponent;
  let fixture: ComponentFixture<ImobiliarioIntradayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImobiliarioIntradayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImobiliarioIntradayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
