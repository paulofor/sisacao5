import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoIntraIndiceComponent } from './ativo-intra-indice.component';

describe('AtivoIntraIndiceComponent', () => {
  let component: AtivoIntraIndiceComponent;
  let fixture: ComponentFixture<AtivoIntraIndiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoIntraIndiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoIntraIndiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
