import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CombinacaoListComponent } from './combinacao-list.component';

describe('CombinacaoListComponent', () => {
  let component: CombinacaoListComponent;
  let fixture: ComponentFixture<CombinacaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CombinacaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CombinacaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
