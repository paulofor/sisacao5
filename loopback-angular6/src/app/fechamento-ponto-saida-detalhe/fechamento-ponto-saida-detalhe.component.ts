import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { FechamentoPontoSaidaApi } from '../shared/sdk';
import { FechamentoPontoSaidaDetalheBaseComponent } from './fechamento-ponto-saida-detalhe-base.component';

@Component({
	selector: 'app-fechamento-ponto-saida-detalhe',
  	templateUrl: './fechamento-ponto-saida-detalhe.component.html',
  	styleUrls: ['./fechamento-ponto-saida-detalhe.component.css']
})
export class FechamentoPontoSaidaDetalheComponent extends FechamentoPontoSaidaDetalheBaseComponent {

	constructor(protected srv: FechamentoPontoSaidaApi, protected router: ActivatedRoute, protected dialog: MatDialog) { 
		super(srv,router,dialog);
	}

}
