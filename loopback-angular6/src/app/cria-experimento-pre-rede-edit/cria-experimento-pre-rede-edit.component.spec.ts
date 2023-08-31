import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriaExperimentoPreRedeEditComponent } from './cria-experimento-pre-rede-edit.component';

describe('CriaExperimentoPreRedeEditComponent', () => {
  let component: CriaExperimentoPreRedeEditComponent;
  let fixture: ComponentFixture<CriaExperimentoPreRedeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriaExperimentoPreRedeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriaExperimentoPreRedeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
