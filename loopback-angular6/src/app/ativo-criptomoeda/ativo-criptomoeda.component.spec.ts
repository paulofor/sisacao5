import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoCriptomoedaComponent } from './ativo-criptomoeda.component';

describe('AtivoCriptomoedaComponent', () => {
  let component: AtivoCriptomoedaComponent;
  let fixture: ComponentFixture<AtivoCriptomoedaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoCriptomoedaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoCriptomoedaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
