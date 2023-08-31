import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { GrupoAcao, RegraProjecao, FechamentoRegraDiaApi, GrupoAcaoApi, RegraProjecaoApi, FechamentoRegraDia, PeriodoExperimento, PeriodoExperimentoApi, PeriodoTreinoRede, PeriodoTreinoRedeApi, ExperimentoPreRedeTreinada, ExperimentoPreRedeTreinadaApi } from '../shared/sdk';

@Component({
  selector: 'app-experimento-pre-rede-treinada-edit',
  templateUrl: './experimento-pre-rede-treinada-edit.component.html',
  styleUrls: ['./experimento-pre-rede-treinada-edit.component.css']
})
export class ExperimentoPreRedeTreinadaEditComponent  extends BaseEditComponent {

  listaGrupoAcao:GrupoAcao[];
  listaRegraProjecao:RegraProjecao[];
  listaPeriodo:PeriodoTreinoRede[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoPreRedeTreinadaApi, protected srvPeriodo: PeriodoTreinoRedeApi,
    private srvGrupoAcao:GrupoAcaoApi, private srvRegraProjecao:RegraProjecaoApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let novo: ExperimentoPreRedeTreinada  = new ExperimentoPreRedeTreinada();
    novo.experimentoPreRedeId = this.origem.id;
    return novo;
  }

  montaCombos(): void {
    this.srvGrupoAcao.find()
      .subscribe((result:GrupoAcao[]) => {
        this.listaGrupoAcao = result;
      });
    this.srvRegraProjecao.find()
      .subscribe((result:RegraProjecao[]) => {
        this.listaRegraProjecao = result;
      })
    this.srvPeriodo.find()
      .subscribe((result:PeriodoTreinoRede[]) => {
        this.listaPeriodo = result;
      })
  }

  preSubmit() {
    delete this.item['regraProjecao'];
    delete this.item['grupoAcao'];
    delete this.item['periodoTreinoRede'];
  }

}
