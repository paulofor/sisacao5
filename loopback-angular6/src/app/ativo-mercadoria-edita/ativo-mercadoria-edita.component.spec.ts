import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoMercadoriaEditaComponent } from './ativo-mercadoria-edita.component';

describe('AtivoMercadoriaEditaComponent', () => {
  let component: AtivoMercadoriaEditaComponent;
  let fixture: ComponentFixture<AtivoMercadoriaEditaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtivoMercadoriaEditaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtivoMercadoriaEditaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
