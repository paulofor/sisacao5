import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { ExperimentoSimulacaoApi, ExperimentoSimulacaoPeriodo, ExperimentoSimulacaoPeriodoApi, PeriodoExperimentoApi } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-periodo-para-experimento',
  templateUrl: './escolhe-periodo-para-experimento.component.html',
  styleUrls: ['./escolhe-periodo-para-experimento.component.css']
})
export class EscolhePeriodoParaExperimentoComponent extends BaseSelecionaEditComponent{


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected srvItem: PeriodoExperimentoApi, protected srvRel: ExperimentoSimulacaoPeriodoApi
  ) {
    super(dialogRef, data, srvItem, srvRel );
  }  


  getNomePropriedadeRel(): string {
    return "experimentoSimulacaoPeriodos";
  }
  criaRelacionamento() {
    return new ExperimentoSimulacaoPeriodo();
  }
  getNomeChaveItem(): string {
    return "id";
  }
  getNomeChaveItemNoRelacionamento(): string {
    return "periodoExperimentoId";
  }
  getNomeChaveOrigemNoRelacionamento(): string {
    return "experimentoSimulacaoId";
  }
  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorExperimento";
  }

  getFiltro() {
    return {
      'order' : 'dataNumFinal',
      'include' : 'experimentoSimulacaoPeriodos'
    }
  }

}



