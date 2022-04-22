import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

import { PeriodoExperimentoApi, ExperimentoSimulacaoPeriodoApi, ExperimentoSimulacaoPeriodo, PeriodoExperimento, ExperimentoSimulacao, ExperimentoSimulacaoApi, CombinacaoParametroApi } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-periodo-corrente-experimento',
  templateUrl: './escolhe-periodo-corrente-experimento.component.html',
  styleUrls: ['./escolhe-periodo-corrente-experimento.component.css']
})
export class EscolhePeriodoCorrenteExperimentoComponent  extends BaseEditComponent {

  listaRelPeriodo: ExperimentoSimulacaoPeriodo[];

  constructor(protected dialogRef: MatDialogRef<EscolhePeriodoCorrenteExperimentoComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoSimulacaoApi, 
    protected srvRel: ExperimentoSimulacaoPeriodoApi, protected srvCombinacao: CombinacaoParametroApi
  ) {
    super(dialogRef,data,servico);
  }



  onSubmit() {
    this.preSubmit();
    console.log('Submit(BaseEdit):' , this.item);
    this.servico.AlteraPeriodoCorrente(this.item, (err, obj) => {
      if (err) {
        console.log("ErroUpsert:" + JSON.stringify(err));
      } else {
        
      }
      this.posSubmit();
    }).subscribe((e: any) => {
      console.log(JSON.stringify(e));
      this.closeDialog();
    });

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
    console.log('item:' , this.item);
    delete this.item['periodoExperimento'];
    delete this.item['experimentoParametros'];
    delete this.item['experimentoSimulacaoPeriodos'];
    delete this.item['grupoAcao'];
    delete this.item['regraSimulacao'];
    //if (!this.item.dataCriacao) {
    //  this.item.dataCriacao = new Date();
    //}
  }

  posSubmit() {
    this.srvCombinacao.LimpaDescricao(this.item.id)
      .subscribe((result) => {
        console.log('Limpeza descricao');
      })
  }
  
  /*
  carregaItens() {
    
  }
  */


}
