import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoCriptomoedaFoxbitComponent } from './ativo-criptomoeda-foxbit.component';

describe('AtivoCriptomoedaFoxbitComponent', () => {
  let component: AtivoCriptomoedaFoxbitComponent;
  let fixture: ComponentFixture<AtivoCriptomoedaFoxbitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoCriptomoedaFoxbitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoCriptomoedaFoxbitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
