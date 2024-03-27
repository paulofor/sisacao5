import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuadroComparaStopGeralComponent } from './quadro-compara-stop-geral.component';

describe('QuadroComparaStopGeralComponent', () => {
  let component: QuadroComparaStopGeralComponent;
  let fixture: ComponentFixture<QuadroComparaStopGeralComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuadroComparaStopGeralComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuadroComparaStopGeralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
