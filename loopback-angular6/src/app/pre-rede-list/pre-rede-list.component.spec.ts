import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreRedeListComponent } from './pre-rede-list.component';

describe('PreRedeListComponent', () => {
  let component: PreRedeListComponent;
  let fixture: ComponentFixture<PreRedeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreRedeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreRedeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
