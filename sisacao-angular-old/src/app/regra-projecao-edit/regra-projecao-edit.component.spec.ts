import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegraProjecaoEditComponent } from './regra-projecao-edit.component';

describe('RegraProjecaoEditComponent', () => {
  let component: RegraProjecaoEditComponent;
  let fixture: ComponentFixture<RegraProjecaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegraProjecaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegraProjecaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
