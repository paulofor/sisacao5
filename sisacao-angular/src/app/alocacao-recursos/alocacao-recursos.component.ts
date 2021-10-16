import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { AlocacaoMovimentacaoEditaComponent } from '../alocacao-movimentacao-edita/alocacao-movimentacao-edita.component';
import { BaseListComponent } from '../base-component/base-list-component';
import { TipoAplicacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-alocacao-recursos',
  templateUrl: './alocacao-recursos.component.html',
  styleUrls: ['./alocacao-recursos.component.css']
})
export class AlocacaoRecursosComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TipoAplicacaoApi) {
    super(dialog,srv)
  }

  getComponente() {
    return AlocacaoMovimentacaoEditaComponent;
  }
 


  getFiltro() {
    let filtro = { 
      'include' : { 'relation' : 'aplicacaoInstituicaos' , 'scope' : {'include' : 'instituicaoFinanceira'}} 
    };
    return filtro;
  }

}