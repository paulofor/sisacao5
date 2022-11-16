import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { GrupoRedeRel, GrupoRedeRelApi, RedeNeuralApi } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-rede-grupo-edit',
  templateUrl: './escolhe-rede-grupo-edit.component.html',
  styleUrls: ['./escolhe-rede-grupo-edit.component.css']
})
export class EscolheRedeGrupoEditComponent extends BaseSelecionaEditComponent{

  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorGrupoRede"
  }
  criaRelacionamento() {
    return new GrupoRedeRel();
  }
  getNomeChaveItem() {
    return "id";
  }
  getNomeChaveItemNoRelacionamento() {
    return "redeNeuralId";
  }
  getNomeChaveOrigemNoRelacionamento() {
    return "grupoRedeId";
  }


  getNomePropriedadeRel() {
    return "grupoRedeRels";
  }

  


   constructor(protected dialogRef: MatDialogRef<EscolheRedeGrupoEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: GrupoRedeRelApi, protected srvAtivo: RedeNeuralApi
  ) {
    super(dialogRef,data,srvAtivo,servico)
  }

 
  getFiltro() {
    let filtro = {
      "where" : { "and" : [ {"entrada1" : this.origem.entrada1} , {"entrada2" : this.origem.entrada2}] },
      "counts" : "grupoRedeRels",
      "order" : "nome",
      "include" : {
        "relation" : "grupoRedeRels",
        "scope" : {
          "where" : { "grupoRedeId" : this.origem.id}
        }
      }
    }
    return filtro;
  }
 
 
}
