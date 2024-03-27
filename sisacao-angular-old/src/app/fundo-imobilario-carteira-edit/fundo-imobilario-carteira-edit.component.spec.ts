import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobilarioCarteiraEditComponent } from './fundo-imobilario-carteira-edit.component';

describe('FundoImobilarioCarteiraEditComponent', () => {
  let component: FundoImobilarioCarteiraEditComponent;
  let fixture: ComponentFixture<FundoImobilarioCarteiraEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobilarioCarteiraEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobilarioCarteiraEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
