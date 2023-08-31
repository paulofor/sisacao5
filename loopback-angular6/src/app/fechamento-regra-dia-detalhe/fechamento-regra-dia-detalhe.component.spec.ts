import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FechamentoRegraDiaDetalheComponent } from './fechamento-regra-dia-detalhe.component';

describe('FechamentoRegraDiaDetalheComponent', () => {
	let component: FechamentoRegraDiaDetalheComponent;
	let fixture: ComponentFixture<FechamentoRegraDiaDetalheComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [ FechamentoRegraDiaDetalheComponent ]
		})
		.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(FechamentoRegraDiaDetalheComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
