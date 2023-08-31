import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoRegraEditaComponent } from './grupo-regra-edita.component';

describe('GrupoRegraEditaComponent', () => {
  let component: GrupoRegraEditaComponent;
  let fixture: ComponentFixture<GrupoRegraEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoRegraEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoRegraEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
