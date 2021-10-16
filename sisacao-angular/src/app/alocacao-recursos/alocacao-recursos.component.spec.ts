import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlocacaoRecursosComponent } from './alocacao-recursos.component';

describe('AlocacaoRecursosComponent', () => {
  let component: AlocacaoRecursosComponent;
  let fixture: ComponentFixture<AlocacaoRecursosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlocacaoRecursosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlocacaoRecursosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
