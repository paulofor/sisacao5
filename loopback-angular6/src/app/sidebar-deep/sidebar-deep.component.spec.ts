import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarDeepComponent } from './sidebar-deep.component';

describe('SidebarDeepComponent', () => {
  let component: SidebarDeepComponent;
  let fixture: ComponentFixture<SidebarDeepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarDeepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarDeepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
