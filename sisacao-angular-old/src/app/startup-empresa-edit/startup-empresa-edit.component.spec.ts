import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartupEmpresaEditComponent } from './startup-empresa-edit.component';

describe('StartupEmpresaEditComponent', () => {
  let component: StartupEmpresaEditComponent;
  let fixture: ComponentFixture<StartupEmpresaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartupEmpresaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartupEmpresaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
