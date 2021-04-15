import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Subscription, interval } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { CUSTO_TRADE } from '../constantes/base.url';
import { OrdemCompraEditaComponent } from '../ordem-compra-edita/ordem-compra-edita.component';
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, ExecucaoSimulacao, ExecucaoSimulacaoApi, OrdemCompraApi } from '../shared/sdk';
import { TradeExecucaoSimulacaoComponent } from '../trade-execucao-simulacao/trade-execucao-simulacao.component';
import { TradeRealEditaComponent } from '../trade-real-edita/trade-real-edita.component';

@Component({
  selector: 'app-execucao-simulacao-monitorada',
  templateUrl: './execucao-simulacao-monitorada.component.html',
  styleUrls: ['./execucao-simulacao-monitorada.component.css']
})
export class ExecucaoSimulacaoMonitoradaComponent extends BaseListComponent{

  private updateSubscription: Subscription;
  private PERCENTUAL_AVISO = 1.5;
  public totalExposicao;

  constructor(protected srv:ExecucaoSimulacaoApi, private srvCotacao: CotacaoIntradayAcaoApi,
    protected dialog: MatDialog, private srvOrdem: OrdemCompraApi) {
    super(dialog, srv)
  }

  getFiltro() {
    return { 
      'where' : {'monitorar' : 1} , 
      'include' : [
        {'relation' : 'regraSimulacao'},
        {'relation' : 'valorMonitorias' , 'scope' : {'limit' : 2 , 'order' : 'diaNumEntrada desc'}} ,
        {'relation' : 'ativoAcao' }
      ], 
      'order' : 'resultado desc'
    }
  }

  getValorLucro(item:ExecucaoSimulacao) {

  }

  getValorPrejuizo(item:ExecucaoSimulacao) {
    
  }

  posCarregaLista() {
    this.carregaPrecoAtual();
    this.carregaExposicao();
    this.carregaOrdem();
    this.updateSubscription = interval(60000)
      .subscribe((val) => { 
        this.carregaPrecoAtual()
      });
    
  }

  carregaOrdem() {
    this.listaBase.forEach((execucao:ExecucaoSimulacao) => {
      this.srv.countOrdemCompras(execucao.id)
        .subscribe((result) => {
          execucao['qtdeOrdem'] = result.count;
        });
      this.srv.countTradeReals(execucao.id, {'posicaoAtual' : 1})
        .subscribe((result) => {
          execucao['qtdeTrade'] = result.count;
        })
    })
  }

  carregaExposicao() {
    this.srvOrdem.TotalExposicaoGeral()
      .subscribe((result) => {
        console.log('Exposicao: ' , result);
        this.totalExposicao = result.valor;
      })
  }

  telaCompra(item:ExecucaoSimulacao) {
    this.dialog.open(TradeRealEditaComponent, {
      width: '900px',
      data: {
          origem: item
      }
    });
  }
  telaOrdem(item:ExecucaoSimulacao) {
    item['pontoSaidaLucro'] = this.pontoSaidaLucro(item);
    item['pontoSaidaPrejuizo'] = this.pontoSaidaPrejuizo(item);
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaExposicao();
    });
    this.dialog.open(OrdemCompraEditaComponent, {
      width: '900px',
      data: {
          origem: item
      }
    });
  }


  carregaPrecoAtual() {
    this.listaBase.forEach((execucao:ExecucaoSimulacao) => {
      this.srvCotacao.AtualPorTicker(execucao.ticker,1)
        .subscribe((cotacao:CotacaoIntradayAcao[]) => {
          execucao['precoAtual'] = cotacao[0].valor;
          execucao['dataHora'] = cotacao[0].dataHora;
        });
      this.srvCotacao.AtualPorTicker(execucao.ticker + "F",1)
        .subscribe((cotacao:CotacaoIntradayAcao[]) => {
          console.log('buscando preço');
          if (cotacao.length>0)
            execucao['precoAtualF'] = cotacao[0].valor;
        })
    })
  }

  classePreco(item:ExecucaoSimulacao) {
    if ((item.valorMonitorias.length>1) && item.valorMonitorias[1].posicao==1) {
      // comprado
      if (item['precoAtual'] < item.valorMonitorias[1].pontoEntrada)
        return "dgc-alerta"
      else
        return ""
    } else {
      // fora
      if (item['precoAtual'] < item.precoEntrada)
        return "dgc-alerta"
      else
        return ""
    }
  }

  valorSaidaLucro(item:ExecucaoSimulacao) {
    let valorEntrada = item.precoEntrada * 100;
    let valorSaida = item.precoEntrada * (1+item.target) * 100;
    return (valorSaida - valorEntrada) - CUSTO_TRADE;
  }
  valorSaidaPrejuizo(item:ExecucaoSimulacao) {
    let valorEntrada = item.precoEntrada * 100;
    let valorSaida = item.precoEntrada * (1-item.stop) * 100;
    return (valorEntrada - valorSaida) - CUSTO_TRADE;
  }

  pontoSaidaLucro(item:ExecucaoSimulacao) {
    let valor = item.precoEntrada * (1+item.target);
    return valor.toFixed(2);
  }
  pontoSaidaPrejuizo(item:ExecucaoSimulacao) {
    let valor = item.precoEntrada * (1-item.stop);
    return valor.toFixed(2);
  }

  classeTargetCompra(item:ExecucaoSimulacao) {
    if ( (item.precoEntrada * (1+item.target)) > item.ativoAcao.max1Mes) {
      return 'dgc-alerta';
    } else {
      return '';
    }
  }
  classeStopCompra(item:ExecucaoSimulacao) {
    if ( (item.precoEntrada * (1-item.stop)) < item.ativoAcao.min1Mes) {
      return 'dgc-vantagem';
    } else {
      return '';
    }
  }

  classeTarget(item) {
    let perc = this.percTarget(item);
    if (perc<=this.PERCENTUAL_AVISO) {
      return 'dgc-alerta  marcatexto'
    } else {
      return '';
    }
  }
  classeStop(item) {
    let perc = this.percStop(item);
    if (perc>=(this.PERCENTUAL_AVISO*-1)) {
      return 'dgc-alerta'
    } else {
      return '';
    }
  }

  percTarget(item:ExecucaoSimulacao) {
    let valor = item.valorMonitorias[1].valorTarget - item['precoAtual'];
    return (valor / item['precoAtual']) * 100;
  }
  percStop(item:ExecucaoSimulacao) {
    let valor = item.valorMonitorias[1].valorStop - item['precoAtual'];
    return (valor / item['precoAtual']) * 100;
  }
  percPrecoEntrada(item:ExecucaoSimulacao) {
    let valor = item.precoEntrada - item['precoAtual'];
    return (valor / item['precoAtual']) * 100;
  }
  percPrecoAtual(preco: number, item:ExecucaoSimulacao) {
    let valor = preco - item['precoAtual'];
    let saida = (valor / item['precoAtual']) * 100;
    return saida.toFixed(1);
  }

  trades(item) {
    console.log('Clicou trades');
    this.dialog.open(TradeExecucaoSimulacaoComponent, {
      width: '900px',
      data: {
          item: item
      }
    });
  }
}
