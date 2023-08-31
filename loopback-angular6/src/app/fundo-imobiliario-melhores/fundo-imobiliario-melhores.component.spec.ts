import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundoImobiliarioMelhoresComponent } from './fundo-imobiliario-melhores.component';

describe('FundoImobiliarioMelhoresComponent', () => {
  let component: FundoImobiliarioMelhoresComponent;
  let fixture: ComponentFixture<FundoImobiliarioMelhoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundoImobiliarioMelhoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundoImobiliarioMelhoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
