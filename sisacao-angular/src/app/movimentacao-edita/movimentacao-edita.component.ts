import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { MelhoresValidacaoPeriodoComponent } from '../melhores-validacao-periodo/melhores-validacao-periodo.component';
import { InstituicaoFinanceira, InstituicaoFinanceiraApi, MovimentacaoValorAplicado, MovimentacaoValorAplicadoApi, TipoAplicacao, TipoAplicacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-movimentacao-edita',
  templateUrl: './movimentacao-edita.component.html',
  styleUrls: ['./movimentacao-edita.component.css']
})
export class MovimentacaoEditaComponent extends BaseEditComponent {

  listaTipo : TipoAplicacao[];
  listaInstituicao : InstituicaoFinanceira[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: MovimentacaoValorAplicadoApi,
    protected srvInstituicao:InstituicaoFinanceiraApi, protected srvTipo: TipoAplicacaoApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let itemNovo:MovimentacaoValorAplicado = new MovimentacaoValorAplicado();
    return itemNovo;
  }


  montaCombos() {
    let filtro = {'order' : 'nome'}
    this.srvInstituicao.find(filtro)
      .subscribe((result:InstituicaoFinanceira[])=> {
        console.log('InstituicaoFinanceira' , result);
        this.listaInstituicao = result;
    })
    this.srvTipo.find(filtro)
      .subscribe((result:TipoAplicacao[])=> {
        console.log('TipoAplicacao' , result);
        this.listaTipo = result;
    })

  }
}


