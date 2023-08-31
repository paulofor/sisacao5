import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { VersaoPreRedeApi } from '../shared/sdk';
import { VersaoPreRedeDetalheBaseComponent } from './versao-pre-rede-detalhe-base.component';

@Component({
	selector: 'app-versao-pre-rede-detalhe',
  	templateUrl: './versao-pre-rede-detalhe.component.html',
  	styleUrls: ['./versao-pre-rede-detalhe.component.css']
})
export class VersaoPreRedeDetalheComponent extends VersaoPreRedeDetalheBaseComponent {

	constructor(protected srv: VersaoPreRedeApi, protected router: ActivatedRoute, protected dialog: MatDialog) { 
		super(srv,router,dialog);
	}

	getFiltro() {
		return {
			'include' : 'preRedeNeural'
		}
	}

}
