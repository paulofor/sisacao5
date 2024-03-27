import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { AtivoAcaoApi, GrupoRegraRel, GrupoRegraRelApi, RegraProjecaoApi, RelGrupoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-regra-grupo-edit',
  templateUrl: './escolhe-regra-grupo-edit.component.html',
  styleUrls: ['./escolhe-regra-grupo-edit.component.css']
})
export class EscolheRegraGrupoEditComponent extends BaseSelecionaEditComponent{

  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorGrupoRegra"
  }
  criaRelacionamento() {
    return new GrupoRegraRel();
  }
  getNomeChaveItem() {
    return "id";
  }
  getNomeChaveItemNoRelacionamento() {
    return "regraProjecaoId";
  }
  getNomeChaveOrigemNoRelacionamento() {
    return "grupoRegraId";
  }


  getNomePropriedadeRel() {
    return "grupoRegraRels";
  }

  


   constructor(protected dialogRef: MatDialogRef<EscolheRegraGrupoEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: GrupoRegraRelApi, protected srvAtivo: RegraProjecaoApi
  ) {
    super(dialogRef,data,srvAtivo,servico)
  }

 
  getFiltro() {
    let filtro = {
      "counts" : "grupoRegraRels",
      "order" : "codigoRegraProjecao",
      "include" : {
        "relation" : "grupoRegraRels",
        "scope" : {
          "where" : { "grupoRegraId" : this.origem.id}
        }
      }
    }
    return filtro;
  }
 
 
}
