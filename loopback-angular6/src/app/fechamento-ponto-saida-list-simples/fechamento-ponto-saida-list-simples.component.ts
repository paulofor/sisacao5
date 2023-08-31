import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { FechamentoPontoSaidaApi } from '../shared/sdk';
import { FechamentoPontoSaidaListSimplesBaseComponent } from './fechamento-ponto-saida-list-simples-base.component';

@Component({
	selector: 'app-fechamento-ponto-saida-list-simples',
  	templateUrl: './fechamento-ponto-saida-list-simples.component.html',
  	styleUrls: ['./fechamento-ponto-saida-list-simples.component.css']
})
export class FechamentoPontoSaidaListSimplesComponent extends FechamentoPontoSaidaListSimplesBaseComponent {

	constructor(protected srv: FechamentoPontoSaidaApi, protected router: ActivatedRoute, protected dialog: MatDialog) { 
		super(srv,router,dialog);
	}

}
