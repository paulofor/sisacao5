import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeiaExperimentoEditComponent } from './ideia-experimento-edit.component';

describe('IdeiaExperimentoEditComponent', () => {
  let component: IdeiaExperimentoEditComponent;
  let fixture: ComponentFixture<IdeiaExperimentoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeiaExperimentoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeiaExperimentoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
