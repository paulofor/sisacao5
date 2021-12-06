import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { InstituicaoFinanceira, InstituicaoFinanceiraApi, TipoAplicacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-alocacao-saldo-mes',
  templateUrl: './alocacao-saldo-mes.component.html',
  styleUrls: ['./alocacao-saldo-mes.component.css']
})
export class AlocacaoSaldoMesComponent extends BaseListComponent {

  listaInstituicao : InstituicaoFinanceira[];
  saldoTotal: number = 0;

  constructor(protected dialog: MatDialog, protected srv:TipoAplicacaoApi, protected srvInstituicao:InstituicaoFinanceiraApi) { 
    super(dialog,srv);
  }


  preCarregaTela() {
    let filtro = {'order' : 'id' , 'include' : 'aplicacaoInstituicaos'}
    this.srvInstituicao.find(filtro)
    .subscribe((resultado: InstituicaoFinanceira[]) => {
      this.listaInstituicao = resultado;
      console.log('listaInstituicao:' , this.listaInstituicao);
    })
  }

  getSaldoInstituicao(item) {
    let saldoAtual = 0;
    for (let i=0; i<item.aplicacaoInstituicaos.length; i++) {
      saldoAtual += item.aplicacaoInstituicaos[i].saldoAtual;
    }
    this.saldoTotal += saldoAtual;
    return saldoAtual;
  }

  getFiltro() {
    return {
       'include' : {
          'relation' : 'aplicacaoInstituicaos' , 'scope' : {'order' : 'instituicaoFinanceiraId'}
       }
    }
  }
}
