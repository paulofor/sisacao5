import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperimentoRedeNeuralEditComponent } from './experimento-rede-neural-edit.component';

describe('ExperimentoRedeNeuralEditComponent', () => {
	let component: ExperimentoRedeNeuralEditComponent;
	let fixture: ComponentFixture<ExperimentoRedeNeuralEditComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [ ExperimentoRedeNeuralEditComponent ]
		})
		.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(ExperimentoRedeNeuralEditComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
