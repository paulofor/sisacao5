import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoAplicacaoEditComponent } from './tipo-aplicacao-edit.component';

describe('TipoAplicacaoEditComponent', () => {
  let component: TipoAplicacaoEditComponent;
  let fixture: ComponentFixture<TipoAplicacaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipoAplicacaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoAplicacaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
