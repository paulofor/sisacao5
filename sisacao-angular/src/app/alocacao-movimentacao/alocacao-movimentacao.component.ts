import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { MovimentacaoEditaComponent } from '../movimentacao-edita/movimentacao-edita.component';
import { MovimentacaoValorAplicadoApi } from '../shared/sdk';

@Component({
  selector: 'app-alocacao-movimentacao',
  templateUrl: './alocacao-movimentacao.component.html',
  styleUrls: ['./alocacao-movimentacao.component.css']
})
export class AlocacaoMovimentacaoComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:MovimentacaoValorAplicadoApi) { 
    super(dialog,srv);
  }


  getComponente() {
    return MovimentacaoEditaComponent;
  }

  getFiltro() {
    return {
       'include' : ['tipoAplicacao' , 'instituicaoFinanceira'],
       'order' : ['data']
    }
  }



}