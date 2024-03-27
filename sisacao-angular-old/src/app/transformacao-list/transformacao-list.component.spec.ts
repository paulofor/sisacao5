import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransformacaoListComponent } from './transformacao-list.component';

describe('TransformacaoListComponent', () => {
  let component: TransformacaoListComponent;
  let fixture: ComponentFixture<TransformacaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransformacaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransformacaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
