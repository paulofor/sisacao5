import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';

import { BaseListComponent } from '../base-component/base-list-component';
import { AtivoAcaoApi, AtivoIndice, AtivoIndiceApi } from '../shared/sdk';

@Component({
  selector: 'app-ativo-acao-resultado-futuro',
  templateUrl: './ativo-acao-resultado-futuro.component.html',
  styleUrls: ['./ativo-acao-resultado-futuro.component.css']
})
export class AtivoAcaoResultadoFuturoComponent extends BaseListComponent  {

  listaIndice : AtivoIndice[];

  constructor(private router: ActivatedRoute,protected dialog: MatDialog, protected srv:AtivoAcaoApi, protected srvIndice:AtivoIndiceApi) {
    super(dialog, srv);
  }


  carregaTela() {
    this.srv.ListaComResultadoMaisRecente()
      .subscribe((result:any[]) => {
         console.log('result1: ' , result);
         this.listaBase = result;
      })
    this.srvIndice.ListaIndiceResultadoMaisRecente()
      .subscribe((result:AtivoIndice[]) => {
         console.log('result2: ' , result);
         this.listaIndice = result;
      })
  }

  grupos(item) {
    let saida = '';
    for (let i=0;i<item.relGrupoAcaos.length;i++) {
      if (i>0) saida += ', '
      saida += item.relGrupoAcaos[i].grupoAcao.nome;
    }
    return saida;
  }
 
  /*
  getComponente() {
    return DataSetEditComponent;
  }

  getDialogo1() {
    return AtributoDataSetEditComponent;
  }
  getDialogo2() {
    return DataSetCreateSqlComponent;
  }
  */



}
