import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RedePerformanceListComponent } from './rede-performance-list.component';

describe('RedePerformanceListComponent', () => {
  let component: RedePerformanceListComponent;
  let fixture: ComponentFixture<RedePerformanceListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RedePerformanceListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RedePerformanceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
