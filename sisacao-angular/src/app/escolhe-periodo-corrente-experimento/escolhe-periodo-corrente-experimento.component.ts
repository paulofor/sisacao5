import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { PeriodoExperimentoApi, ExperimentoSimulacaoPeriodoApi, ExperimentoSimulacaoPeriodo, PeriodoExperimento, ExperimentoSimulacao, ExperimentoSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-periodo-corrente-experimento',
  templateUrl: './escolhe-periodo-corrente-experimento.component.html',
  styleUrls: ['./escolhe-periodo-corrente-experimento.component.css']
})
export class EscolhePeriodoCorrenteExperimentoComponent  extends BaseEditComponent {

  listaRelPeriodo: ExperimentoSimulacaoPeriodo[];

  constructor(protected dialogRef: MatDialogRef<EscolhePeriodoCorrenteExperimentoComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoSimulacaoApi, protected srvRel: ExperimentoSimulacaoPeriodoApi
  ) {
    super(dialogRef,data,servico);
  }


  montaCombos() {
    let filtro = {
      'where' : {'experimentoSimulacaoId' : this.item.id },
      'include' : 'periodoExperimento'
    }
    this.srvRel.find(filtro)
      .subscribe((result:ExperimentoSimulacaoPeriodo[])=> {
        console.log('RelPeriodoExperimento' , result);
        this.listaRelPeriodo = result;

      })

  }

  preSubmit() {
    delete this.item['periodoExperimento'];
    delete this.item['experimentoParametros'];
    delete this.item['experimentoSimulacaoPeriodos'];
    delete this.item['grupoAcao'];
    delete this.item['regraSimulacao'];
    //if (!this.item.dataCriacao) {
    //  this.item.dataCriacao = new Date();
    //}
  }
  
  /*
  carregaItens() {
    
  }
  */


}
