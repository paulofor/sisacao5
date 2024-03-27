import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

import { BaseListComponent } from '../base-component/base-list-component';
import { BaseSelecionaEditComponent } from '../base-component/base-seleciona-component';
import { AtivoAcao, AtivoAcaoApi, BaseLoopBackApi, RelGrupoAcao, RelGrupoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-acao-grupo-edit',
  templateUrl: './escolhe-acao-grupo-edit.component.html',
  styleUrls: ['./escolhe-acao-grupo-edit.component.css']
})
export class EscolheAcaoGrupoEditComponent extends BaseSelecionaEditComponent{

  getNomeFuncaoAtualizacaoRelacionamento(): string {
    return "AtualizaPorGrupoAcao"
  }
  criaRelacionamento() {
    return new RelGrupoAcao();
  }
  getNomeChaveItem() {
    return "ticker";
  }
  getNomeChaveItemNoRelacionamento() {
    return "ticker";
  }
  getNomeChaveOrigemNoRelacionamento() {
    return "grupoAcaoId";
  }


  getNomePropriedadeRel() {
    return "relGrupoAcaos";
  }

  


   constructor(protected dialogRef: MatDialogRef<EscolheAcaoGrupoEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RelGrupoAcaoApi, protected srvAtivo: AtivoAcaoApi
  ) {
    super(dialogRef,data,srvAtivo,servico)
  }

 
  getFiltro() {
    let filtro = {
      "counts" : "relGrupoAcaos",
      "order" : "mediaNegocio3Mes DESC",
      "include" : {
        "relation" : "relGrupoAcaos",
        "scope" : {
          "where" : { "grupoAcaoId" : this.origem.id}
        }
      }
    }
    return filtro;
  }
 
 
}
