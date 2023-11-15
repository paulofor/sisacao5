import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { ExperimentoRedeNeuralApi } from '../shared/sdk';
import { ExperimentoRedeNeuralListBaseComponent } from './experimento-rede-neural-list-base.component';

@Component({
	selector: 'app-experimento-rede-neural-list',
  	templateUrl: './experimento-rede-neural-list.component.html',
  	styleUrls: ['./experimento-rede-neural-list.component.css']
})
export class ExperimentoRedeNeuralListComponent extends ExperimentoRedeNeuralListBaseComponent {

	constructor(protected srv: ExperimentoRedeNeuralApi, protected router: ActivatedRoute, protected dialog: MatDialog) { 
		super(srv,router,dialog);
	}

}
