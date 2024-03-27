import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RendaFixaPrivadaMelhoresComponent } from './renda-fixa-privada-melhores.component';

describe('RendaFixaPrivadaMelhoresComponent', () => {
  let component: RendaFixaPrivadaMelhoresComponent;
  let fixture: ComponentFixture<RendaFixaPrivadaMelhoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RendaFixaPrivadaMelhoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RendaFixaPrivadaMelhoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
