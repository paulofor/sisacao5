import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartupFundoEditComponent } from './startup-fundo-edit.component';

describe('StartupFundoEditComponent', () => {
  let component: StartupFundoEditComponent;
  let fixture: ComponentFixture<StartupFundoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartupFundoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartupFundoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
