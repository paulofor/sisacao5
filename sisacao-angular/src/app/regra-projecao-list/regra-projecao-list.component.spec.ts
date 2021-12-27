import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegraProjecaoListComponent } from './regra-projecao-list.component';

describe('RegraProjecaoListComponent', () => {
  let component: RegraProjecaoListComponent;
  let fixture: ComponentFixture<RegraProjecaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegraProjecaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegraProjecaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
