import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartupFundoListComponent } from './startup-fundo-list.component';

describe('StartupFundoListComponent', () => {
  let component: StartupFundoListComponent;
  let fixture: ComponentFixture<StartupFundoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartupFundoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartupFundoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
