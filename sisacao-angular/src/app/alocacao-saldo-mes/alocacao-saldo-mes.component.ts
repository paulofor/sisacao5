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

  constructor(protected dialog: MatDialog, protected srv:TipoAplicacaoApi, protected srvInstituicao:InstituicaoFinanceiraApi) { 
    super(dialog,srv);
  }


  preCarregaTela() {
    let filtro = {'order' : 'id'}
    this.srvInstituicao.find(filtro)
    .subscribe((resultado: InstituicaoFinanceira[]) => {
      this.listaInstituicao = resultado;
      console.log('listaInstituicao:' , this.listaInstituicao);
    })
  }



  getFiltro() {
    return {
       'include' : {
          'relation' : 'aplicacaoInstituicaos' , 'scope' : {'order' : 'instituicaoFinanceiraId'}
       }
    }
  }
}
