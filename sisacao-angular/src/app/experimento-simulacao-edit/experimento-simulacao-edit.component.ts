import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ExperimentoSimulacao, ExperimentoSimulacaoApi, GrupoAcao, GrupoAcaoApi, RegraSimulacao, RegraSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-experimento-simulacao-edit',
  templateUrl: './experimento-simulacao-edit.component.html',
  styleUrls: ['./experimento-simulacao-edit.component.css']
})
export class ExperimentoSimulacaoEditComponent extends BaseEditComponent {

  listaRegra:RegraSimulacao[];
  listaGrupoAcao:GrupoAcao[];


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoSimulacaoApi,
    private srvRegra: RegraSimulacaoApi, private srvGrupoAcao: GrupoAcaoApi
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
      });
    this.srvGrupoAcao.find({'order' : 'nome'})
      .subscribe((result:GrupoAcao[]) => {
        this.listaGrupoAcao = result;
      })
  }

  preSubmit() {
    delete this.item['experimentoParametros'];
    delete this.item['grupoAcao'];
    delete this.item['regraSimulacao'];
  }

}
