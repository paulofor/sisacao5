import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { PlanoMensalEditaComponent } from '../plano-mensal-edita/plano-mensal-edita.component';
import { TipoAplicacao, TipoAplicacaoApi, TipoAplicacaoSaldoMes, TipoAplicacaoSaldoMesApi } from '../shared/sdk';

@Component({
  selector: 'app-plano-mensal',
  templateUrl: './plano-mensal.component.html',
  styleUrls: ['./plano-mensal.component.css']
})
export class PlanoMensalComponent extends BaseListComponent {

  totalAtual: number;
  listaTotal : TipoAplicacaoSaldoMes[] =[];

  constructor(protected dialog: MatDialog, protected srv:TipoAplicacaoApi, protected srvTipo:TipoAplicacaoSaldoMesApi) { 
    super(dialog,srv)
  }

  getDialogo1() : any {
    return PlanoMensalEditaComponent;
  }
 
  posCarregaLista(): void {
      this.totalAtual = 0
      for (let i=0;i<this.listaBase.length;i++) {
        let tipo : TipoAplicacao = this.listaBase[i];
        this.totalAtual += tipo.saldoAtual;
      }
      let filtro = {
        'where' : {'tipoAplicacaoId' : 0},
        'order' : 'diaNumReferencia'
      } 
      this.srvTipo.find(filtro)
        .subscribe((result:TipoAplicacaoSaldoMes[]) => {
        this.listaTotal = result;
      })
  }

  getFiltro() {
    return {
      'order' : 'saldoAtual desc',
      'include' : {'relation' : 'tipoAplicacaoSaldoMes' , 'scope' : {
        'order' : 'diaNumReferencia'
      }}
    }
  }

  atualizaGeral() {
    this.srvTipo.AtualizaGeral()
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  projecao(item) {
    console.log('projecao-item:' , item);
    this.srvTipo.CalculaProjecao(item.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }
  

  classeProjecao(item) {
    if (item.sucessoProjecao==1) return 'dgc-azul dgc-texto-leve';
    if (item.sucessoProjecao==-1) return 'dgc-vermelho dgc-texto-leve';
    return '';
  }

}
