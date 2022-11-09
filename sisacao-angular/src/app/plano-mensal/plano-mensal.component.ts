import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TipoAplicacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-plano-mensal',
  templateUrl: './plano-mensal.component.html',
  styleUrls: ['./plano-mensal.component.css']
})
export class PlanoMensalComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TipoAplicacaoApi) { 
    super(dialog,srv)
  }

 

  getFiltro() {
    return {
      'order' : 'saldoAtual desc',
      'include' : {'relation' : 'tipoAplicacaoSaldoMes' , 'scope' : {
        'order' : 'diaNumReferencia'
      }}
    }
  }

  
  

 

}
