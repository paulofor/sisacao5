import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartupInvestimentoEditComponent } from './startup-investimento-edit.component';

describe('StartupInvestimentoEditComponent', () => {
  let component: StartupInvestimentoEditComponent;
  let fixture: ComponentFixture<StartupInvestimentoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartupInvestimentoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartupInvestimentoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
