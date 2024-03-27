import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeiaExperimentoListComponent } from './ideia-experimento-list.component';

describe('IdeiaExperimentoListComponent', () => {
  let component: IdeiaExperimentoListComponent;
  let fixture: ComponentFixture<IdeiaExperimentoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeiaExperimentoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeiaExperimentoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
