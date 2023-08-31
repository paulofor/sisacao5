import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { GrupoRede, GrupoAcao, PeriodoTreinoRede, GrupoRegra, TreinoGrupoRedeApi, GrupoRedeApi, GrupoAcaoApi, PeriodoTreinoRedeApi, RegraProjecaoApi, RedeNeural, TipoExemploTreino, RegraProjecao, TreinoGrupoRede, GrupoRegraApi } from '../shared/sdk';

@Component({
  selector: 'app-treino-grupo-edita',
  templateUrl: './treino-grupo-edita.component.html',
  styleUrls: ['./treino-grupo-edita.component.css']
})
export class TreinoGrupoEditaComponent  extends BaseEditComponent {

  listaGrupoRede: GrupoRede[];
  listaGrupoAcao: GrupoAcao[];
  listaPeriodoTreino: PeriodoTreinoRede[];
  listaGrupoRegra: GrupoRegra[];


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TreinoGrupoRedeApi,
    protected srvGrupoRede : GrupoRedeApi, protected srvGrupoAcao: GrupoAcaoApi,
    protected srvPeriodoTreinoRede : PeriodoTreinoRedeApi, protected srvGrupoRegra: GrupoRegraApi
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let treino = new TreinoGrupoRede();
    //periodo.permiteEditar = 1;
    return treino;
  }

  preSubmit() {
    delete this.item['grupoRede'];
    delete this.item['grupoAcao'];
    delete this.item['periodoTreinoRede'];
    delete this.item['grupoRegra'];
  }

  montaCombos() {
    this.srvGrupoRede.find()
      .subscribe((result: GrupoRede[]) => {
        this.listaGrupoRede = result;
      });
    this.srvGrupoAcao.find()
      .subscribe((result: GrupoAcao[]) => {
        this.listaGrupoAcao = result;
      })
    this.srvPeriodoTreinoRede.find({'order' : 'diaNumFinalTeste desc'})
      .subscribe((result: PeriodoTreinoRede[]) => {
        this.listaPeriodoTreino = result;
      });
    this.srvGrupoRegra.find()
      .subscribe((result: GrupoRegra[]) => {
        this.listaGrupoRegra = result;
      });
  }

  listaRedes(item:TreinoGrupoRede) {
    let saida = ''
    for (let i=0;i<item.grupoRede.grupoRedeRels.length;i++) {
      if (i!=0) saida += ", " + item.grupoRede.grupoRedeRels[i].redeNeural.nome;
      else saida = item.grupoRede.grupoRedeRels[i].redeNeural.nome;
    }
    return saida;

  }

}