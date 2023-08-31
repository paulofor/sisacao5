import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VersaoPreRedeDetalheComponent } from './versao-pre-rede-detalhe.component';

describe('VersaoPreRedeDetalheComponent', () => {
	let component: VersaoPreRedeDetalheComponent;
	let fixture: ComponentFixture<VersaoPreRedeDetalheComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [ VersaoPreRedeDetalheComponent ]
		})
		.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(VersaoPreRedeDetalheComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
