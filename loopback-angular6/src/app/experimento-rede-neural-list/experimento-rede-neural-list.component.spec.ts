import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperimentoRedeNeuralListComponent } from './experimento-rede-neural-list.component';

describe('ExperimentoRedeNeuralListComponent', () => {
	let component: ExperimentoRedeNeuralListComponent;
	let fixture: ComponentFixture<ExperimentoRedeNeuralListComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [ ExperimentoRedeNeuralListComponent ]
		})
		.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(ExperimentoRedeNeuralListComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
