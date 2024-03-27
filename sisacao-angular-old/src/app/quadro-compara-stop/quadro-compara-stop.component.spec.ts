import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuadroComparaStopComponent } from './quadro-compara-stop.component';

describe('QuadroComparaStopComponent', () => {
  let component: QuadroComparaStopComponent;
  let fixture: ComponentFixture<QuadroComparaStopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuadroComparaStopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuadroComparaStopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
