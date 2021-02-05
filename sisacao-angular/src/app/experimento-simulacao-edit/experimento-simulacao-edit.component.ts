import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ExperimentoSimulacao, ExperimentoSimulacaoApi, RegraSimulacao, RegraSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-experimento-simulacao-edit',
  templateUrl: './experimento-simulacao-edit.component.html',
  styleUrls: ['./experimento-simulacao-edit.component.css']
})
export class ExperimentoSimulacaoEditComponent extends BaseEditComponent {

  listaRegra:RegraSimulacao[];


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoSimulacaoApi,
    private srvRegra: RegraSimulacaoApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new ExperimentoSimulacao();
  }

  montaCombos() {
    this.srvRegra.find({'order' : 'nome'})
      .subscribe((result:RegraSimulacao[]) => {
        this.listaRegra = result;
      })
  }

}
