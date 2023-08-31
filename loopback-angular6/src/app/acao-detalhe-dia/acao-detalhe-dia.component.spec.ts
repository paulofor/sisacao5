import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AcaoDetalheDiaComponent } from './acao-detalhe-dia.component';

describe('AcaoDetalheDiaComponent', () => {
  let component: AcaoDetalheDiaComponent;
  let fixture: ComponentFixture<AcaoDetalheDiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AcaoDetalheDiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AcaoDetalheDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
