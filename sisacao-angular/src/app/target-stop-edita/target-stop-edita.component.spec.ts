import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TargetStopEditaComponent } from './target-stop-edita.component';

describe('TargetStopEditaComponent', () => {
  let component: TargetStopEditaComponent;
  let fixture: ComponentFixture<TargetStopEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TargetStopEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TargetStopEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
