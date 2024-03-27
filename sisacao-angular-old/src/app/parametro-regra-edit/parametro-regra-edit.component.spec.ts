import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametroRegraEditComponent } from './parametro-regra-edit.component';

describe('ParametroRegraEditComponent', () => {
  let component: ParametroRegraEditComponent;
  let fixture: ComponentFixture<ParametroRegraEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParametroRegraEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametroRegraEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
