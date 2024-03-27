import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoAplicacaoListComponent } from './tipo-aplicacao-list.component';

describe('TipoAplicacaoListComponent', () => {
  let component: TipoAplicacaoListComponent;
  let fixture: ComponentFixture<TipoAplicacaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipoAplicacaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoAplicacaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
