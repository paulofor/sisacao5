import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

import { BaseDisplayComponent } from '../base-component/base-display-component';

import { MovimentacaoValorAplicadoApi, InstituicaoFinanceiraApi, TipoAplicacaoApi, RelGrupoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-grupo-para-acao',
  templateUrl: './grupo-para-acao.component.html',
  styleUrls: ['./grupo-para-acao.component.css']
})
export class GrupoParaAcaoComponent  extends BaseDisplayComponent{

  grupos:string;

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RelGrupoAcaoApi,
    
  ) {
    super(dialogRef,data,servico);
  }
 

  getFiltro() {
    return {
      'where' : {'ticker' : this.origem.ticker },
      'include' : 'grupoAcao'
    }
   
  }


}
