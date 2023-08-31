import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { FechamentoRegraDiaApi, FechamentoRegraDiaQuantidadeApi } from '../shared/sdk';
import { FechamentoRegraDiaDetalheBaseComponent } from './fechamento-regra-dia-detalhe-base.component';

@Component({
	selector: 'app-fechamento-regra-dia-detalhe',
  	templateUrl: './fechamento-regra-dia-detalhe.component.html',
  	styleUrls: ['./fechamento-regra-dia-detalhe.component.css']
})
export class FechamentoRegraDiaDetalheComponent extends FechamentoRegraDiaDetalheBaseComponent {

	constructor(protected srv: FechamentoRegraDiaApi, protected router: ActivatedRoute, protected dialog: MatDialog,
		private srvQtde: FechamentoRegraDiaQuantidadeApi) { 
		super(srv,router,dialog);
	}

	getFiltro() {
		return {
			'include' : {
				'relation': 'fechamentoRegraDiaQuantidades' , 'scope' : {
					'limit' : 30,
					"where": {
						"or": [
						  { "quantidadeCompra": { "gt": 0 } },
						  { "quantidadeVenda": { "gt": 0 } }
						]
					  },
					'order' : 'diaNum desc'
				}
			}
		};
	}

	atualizaQtde() {
		this.srvQtde.AtualizaParaFechamentoRegra(this.principal.id)
			.subscribe((result) => {
				this.carregaTela();
			})
	}
}

