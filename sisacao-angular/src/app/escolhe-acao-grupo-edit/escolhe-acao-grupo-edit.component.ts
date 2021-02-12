import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { BaseListComponent } from '../base-component/base-list-component';
import { AtivoAcao, AtivoAcaoApi, BaseLoopBackApi, RelGrupoAcao, RelGrupoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-escolhe-acao-grupo-edit',
  templateUrl: './escolhe-acao-grupo-edit.component.html',
  styleUrls: ['./escolhe-acao-grupo-edit.component.css']
})
export class EscolheAcaoGrupoEditComponent extends BaseEditComponent{

  listaAcao:AtivoAcao[];


   constructor(protected dialogRef: MatDialogRef<EscolheAcaoGrupoEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RelGrupoAcaoApi, private srvAtivo: AtivoAcaoApi
  ) {
    super(dialogRef,data,servico)
  }

  onSubmit() {
    for(let i=0;i<this.listaAcao.length;i++) {
      if (this.listaAcao[i].relGrupoAcaos.length>0) {
        console.log(this.listaAcao[i].ticker)
      }
    }
  }
  
  getCheck(acao:AtivoAcao) : boolean {
    return (acao.relGrupoAcaos.length>0);
  }
  onChange(event, index, acao : AtivoAcao) {
    console.log('event', event);
    console.log('acao:' , acao);
    if (event.checked) {
      let relNovo:RelGrupoAcao = new RelGrupoAcao();
      relNovo.grupoAcaoId = this.origem.id;
      relNovo.ticker = acao.ticker;
      acao.relGrupoAcaos.push(relNovo);
    } else {
      acao.relGrupoAcaos = [];
    }
  }
 
  posItem() {
    /* Modelo copiado  */
    /*
    let filtro = {
      "where" : { "ativo" : 1 },
      "order" : "ordenacao ASC",
      "include": {
          "relation": "processoNegocioEtapaProjetos",
          "scope": {
              "where": { "processoNegocioId": idProcessoNegocio }
          }
      }
    }
    */
    let filtro = {
      "order" : "ticker ASC",
      "include" : {
        "relation" : "relGrupoAcaos",
        "scope" : {
          "where" : { "grupoAcaoId" : this.origem.id}
        }
      }
    }
    this.srvAtivo.find(filtro)
      .subscribe((result: AtivoAcao[]) => {
        this.listaAcao = result;
        console.log('listaAcao', this.listaAcao);
      })
  }
}
