import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FechamentoPontoSaidaListSimplesComponent } from './fechamento-ponto-saida-list-simples.component';

describe('FechamentoPontoSaidaListSimplesComponent', () => {
	let component: FechamentoPontoSaidaListSimplesComponent;
	let fixture: ComponentFixture<FechamentoPontoSaidaListSimplesComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [ FechamentoPontoSaidaListSimplesComponent ]
		})
		.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(FechamentoPontoSaidaListSimplesComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
