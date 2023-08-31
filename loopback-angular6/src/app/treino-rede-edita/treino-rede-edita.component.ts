import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TreinoRedeApi, TreinoRede, RedeNeuralApi, GrupoAcaoApi, PeriodoTreinoRedeApi, TipoExemploTreinoApi, RegraProjecaoApi, RedeNeural, GrupoAcao, PeriodoTreinoRede, TipoExemploTreino, RegraProjecao } from '../shared/sdk';

@Component({
  selector: 'app-treino-rede-edita',
  templateUrl: './treino-rede-edita.component.html',
  styleUrls: ['./treino-rede-edita.component.css']
})
export class TreinoRedeEditaComponent  extends BaseEditComponent {

  listaRede: RedeNeural[];
  listaGrupoAcao: GrupoAcao[];
  listaPeriodoTreino: PeriodoTreinoRede[];
  listaTipoExemplo:TipoExemploTreino[];
  listaRegraProjecao: RegraProjecao[];


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TreinoRedeApi,
    protected srvRedeNeural : RedeNeuralApi, protected srvGrupoAcao: GrupoAcaoApi,
    protected srvPeriodoTreinoRede : PeriodoTreinoRedeApi, protected srvTipoExemploTreino: TipoExemploTreinoApi,
    protected srvRegraProjecao: RegraProjecaoApi
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let treino = new TreinoRede();
    //periodo.permiteEditar = 1;
    return treino;
  }

  preSubmit() {
    delete this.item['redeNeural'];
    delete this.item['grupoAcao'];
    delete this.item['periodoTreinoRede'];
    delete this.item['tipoExemploTreino'];
    delete this.item['regraProjecao'];
  }

  montaCombos() {
    this.srvRedeNeural.find()
      .subscribe((result:RedeNeural[]) => {
        this.listaRede = result;
      });
    this.srvGrupoAcao.find()
      .subscribe((result:GrupoAcao[]) => {
    this.listaGrupoAcao = result;
      })
    this.srvPeriodoTreinoRede.find()
      .subscribe((result:PeriodoTreinoRede[]) => {
        this.listaPeriodoTreino = result;
      });
    this.srvTipoExemploTreino.find()
      .subscribe((result:TipoExemploTreino[]) => {
        this.listaTipoExemplo = result;
      })
    this.srvRegraProjecao.find()
      .subscribe((result:RegraProjecao[]) => {
        this.listaRegraProjecao = result;
      });
   
  }
}