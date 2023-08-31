import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreRedeVersaoEditComponent } from './pre-rede-versao-edit.component';

describe('PreRedeVersaoEditComponent', () => {
  let component: PreRedeVersaoEditComponent;
  let fixture: ComponentFixture<PreRedeVersaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreRedeVersaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreRedeVersaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
