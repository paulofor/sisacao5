import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { interval, Subscription } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { SaldoCorrenteFixoEditComponent } from '../saldo-corrente-fixo-edit/saldo-corrente-fixo-edit.component';
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, TradeReal, TradeRealApi } from '../shared/sdk';
import { TradeRealListaEditComponent } from '../trade-real-lista-edit/trade-real-lista-edit.component';

@Component({
  selector: 'app-trade-real-lista',
  templateUrl: './trade-real-lista.component.html',
  styleUrls: ['./trade-real-lista.component.css']
})
export class TradeRealListaComponent extends BaseListComponent {

  private updateSubscription: Subscription;
  financeiroTotal : number;

  constructor(protected dialog: MatDialog, protected srv:TradeRealApi, private srvCotacao: CotacaoIntradayAcaoApi) { 
    super(dialog,srv);
  }

  vermelhoAzul(valor) {
    if (valor >0 ) {
      return 'dgc-azul'
    } 
    if (valor<0) {
      return 'dgc-vermelho'
    }
    return '';
  }


  carregaPrecoAtual() {
    this.financeiroTotal = 0;
    this.listaBase.forEach((trade:TradeReal) => {
      this.srvCotacao.AtualPorTicker(trade.ticker,1)
        .subscribe((cotacao:CotacaoIntradayAcao[]) => {
          trade['precoAtual'] = cotacao[0].valor;
          trade['dataHora'] = cotacao[0].dataHora;
          if (trade.posicaoAtual==1) {
            trade['percentual'] = 100* ((trade['precoAtual'] - trade['precoEntrada']) / trade['precoEntrada']);
            trade['financeiro'] = (trade['precoAtual'] - trade['precoEntrada']) * trade.quantidade;
            this.financeiroTotal += trade['financeiro'];
          }
          
        });
      this.srvCotacao.AtualPorTicker(trade.ticker + "F",1)
        .subscribe((cotacao:CotacaoIntradayAcao[]) => {
          console.log('buscando preço');
          if (cotacao.length>0)
          trade['precoAtualF'] = cotacao[0].valor;
        })
    })
  }

  getComponente() {
    return TradeRealListaEditComponent;
  }
 
  calcular(item:TradeReal) {
   if (item.posicaoAtual==0) {
     this.srv.CalculaSaida(item.id)
      .subscribe((result) => {
        this.carregaTela();
      })
   }
   if (item.posicaoAtual==1) {
    this.srv.CalculaEstimativa(item.id)
     .subscribe((result) => {
       this.carregaTela();
     })
  }
  }


  getFiltro() {
    return {
      'order' : 'dataEntrada desc',
      'include' : [
          {'relation' : 'execucaoSimulacao'},
          {'relation' : 'ativoAcao' }
      ]
    }
  }

  posCarregaLista() {
    this.carregaPrecoAtual();
    this.updateSubscription = interval(300000)
      .subscribe((val) => { 
        this.carregaPrecoAtual()
      });
    
  }

  editaSaldoFixo() {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(SaldoCorrenteFixoEditComponent, {
      width: '800px',
    });
  }

}
