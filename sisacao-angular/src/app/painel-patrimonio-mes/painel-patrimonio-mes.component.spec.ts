import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelPatrimonioMesComponent } from './painel-patrimonio-mes.component';

describe('PainelPatrimonioMesComponent', () => {
  let component: PainelPatrimonioMesComponent;
  let fixture: ComponentFixture<PainelPatrimonioMesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PainelPatrimonioMesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PainelPatrimonioMesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
