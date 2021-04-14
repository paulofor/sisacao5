import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Subscription, interval } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { OrdemCompraEditaComponent } from '../ordem-compra-edita/ordem-compra-edita.component';
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, OrdemCompra, OrdemCompraApi } from '../shared/sdk';

@Component({
  selector: 'app-ordem-compra-lista',
  templateUrl: './ordem-compra-lista.component.html',
  styleUrls: ['./ordem-compra-lista.component.css']
})
export class OrdemCompraListaComponent extends BaseListComponent{

  private updateSubscription: Subscription;
  private totalExposicao;

  constructor(protected dialog: MatDialog, protected srv:OrdemCompraApi, private srvCotacao: CotacaoIntradayAcaoApi) { 
    super(dialog,srv)
  }


  criaItem() {
    return new OrdemCompra();
  }

  getComponente() {
    return OrdemCompraEditaComponent;
  }
  posCarregaLista() {
    this.carregaPrecoAtual();
    this.carregaExposicao();
    this.updateSubscription = interval(60000)
    .subscribe((val) => { 
      this.carregaPrecoAtual()
    });
  }

  carregaPrecoAtual() {
    this.listaBase.forEach((ordem:OrdemCompra) => {
      this.srvCotacao.AtualPorTicker(ordem.ticker,1)
        .subscribe((cotacao:CotacaoIntradayAcao[]) => {
          ordem['precoAtual'] = cotacao[0].valor;
          ordem['dataHora'] = cotacao[0].dataHora;
        });
      this.srvCotacao.AtualPorTicker(ordem.ticker + "F",1)
        .subscribe((cotacao:CotacaoIntradayAcao[]) => {
          console.log('buscando preço');
          if (cotacao.length>0)
          ordem['precoAtualF'] = cotacao[0].valor;
        })
    })
  }

  carregaExposicao() {
    this.srv.TotalExposicaoGeral()
      .subscribe((result) => {
        this.totalExposicao = result.valor;
      })
  }

}
