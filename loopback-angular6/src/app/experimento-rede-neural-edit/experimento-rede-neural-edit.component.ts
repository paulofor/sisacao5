import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { ExperimentoRedeNeuralApi } from '../shared/sdk';
import { ExperimentoRedeNeuralEditBaseComponent } from './experimento-rede-neural-edit-base.component';

@Component({
	selector: 'app-experimento-rede-neural-edit',
  	templateUrl: './experimento-rede-neural-edit.component.html',
  	styleUrls: ['./experimento-rede-neural-edit.component.css']
})
export class ExperimentoRedeNeuralEditComponent extends ExperimentoRedeNeuralEditBaseComponent {

	 constructor(protected dialogRef: MatDialogRef<any>
	    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoRedeNeuralApi
		  ) {
	   super(dialogRef,data,servico);
	}

}
