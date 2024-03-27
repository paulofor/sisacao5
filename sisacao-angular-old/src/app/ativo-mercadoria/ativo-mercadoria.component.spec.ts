import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoMercadoriaComponent } from './ativo-mercadoria.component';

describe('AtivoMercadoriaComponent', () => {
  let component: AtivoMercadoriaComponent;
  let fixture: ComponentFixture<AtivoMercadoriaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoMercadoriaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoMercadoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
