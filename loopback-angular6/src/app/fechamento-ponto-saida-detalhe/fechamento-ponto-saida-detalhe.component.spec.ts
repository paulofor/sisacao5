import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FechamentoPontoSaidaDetalheComponent } from './fechamento-ponto-saida-detalhe.component';

describe('FechamentoPontoSaidaDetalheComponent', () => {
	let component: FechamentoPontoSaidaDetalheComponent;
	let fixture: ComponentFixture<FechamentoPontoSaidaDetalheComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [ FechamentoPontoSaidaDetalheComponent ]
		})
		.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(FechamentoPontoSaidaDetalheComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
