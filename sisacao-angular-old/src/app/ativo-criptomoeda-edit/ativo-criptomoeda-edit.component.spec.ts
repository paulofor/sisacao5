import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoCriptomoedaEditComponent } from './ativo-criptomoeda-edit.component';

describe('AtivoCriptomoedaEditComponent', () => {
  let component: AtivoCriptomoedaEditComponent;
  let fixture: ComponentFixture<AtivoCriptomoedaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoCriptomoedaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoCriptomoedaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
