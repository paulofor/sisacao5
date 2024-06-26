import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';

import { BaseListComponent } from '../base-component/base-list-component';
import { AtivoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-ativo-acao-resultado-futuro',
  templateUrl: './ativo-acao-resultado-futuro.component.html',
  styleUrls: ['./ativo-acao-resultado-futuro.component.css']
})
export class AtivoAcaoResultadoFuturoComponent extends BaseListComponent  {

  constructor(private router: ActivatedRoute,protected dialog: MatDialog, protected srv:AtivoAcaoApi) {
    super(dialog, srv);
  }


  carregaTela() {
    this.srv.ListaComResultadoMaisRecente()
      .subscribe((result:any[]) => {
         console.log('result: ' , result);
         this.listaBase = result;
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
