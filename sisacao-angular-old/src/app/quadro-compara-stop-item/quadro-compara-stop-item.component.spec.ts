import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuadroComparaStopItemComponent } from './quadro-compara-stop-item.component';

describe('QuadroComparaStopItemComponent', () => {
  let component: QuadroComparaStopItemComponent;
  let fixture: ComponentFixture<QuadroComparaStopItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuadroComparaStopItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuadroComparaStopItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
