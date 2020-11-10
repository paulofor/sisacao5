import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartupEmpresaListComponent } from './startup-empresa-list.component';

describe('StartupEmpresaListComponent', () => {
  let component: StartupEmpresaListComponent;
  let fixture: ComponentFixture<StartupEmpresaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartupEmpresaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartupEmpresaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
