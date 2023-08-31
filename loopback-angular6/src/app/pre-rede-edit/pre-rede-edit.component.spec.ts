import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreRedeEditComponent } from './pre-rede-edit.component';

describe('PreRedeEditComponent', () => {
  let component: PreRedeEditComponent;
  let fixture: ComponentFixture<PreRedeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreRedeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreRedeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
