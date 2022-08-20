import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoRedeEditaComponent } from './grupo-rede-edita.component';

describe('GrupoRedeEditaComponent', () => {
  let component: GrupoRedeEditaComponent;
  let fixture: ComponentFixture<GrupoRedeEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoRedeEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoRedeEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
