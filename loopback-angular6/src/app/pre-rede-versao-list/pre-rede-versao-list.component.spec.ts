import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreRedeVersaoListComponent } from './pre-rede-versao-list.component';

describe('PreRedeVersaoListComponent', () => {
  let component: PreRedeVersaoListComponent;
  let fixture: ComponentFixture<PreRedeVersaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreRedeVersaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreRedeVersaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
