import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { Subscription, interval } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { CUSTO_TRADE, PERCENTUAL_AVISO } from '../constantes/base.url';
import { OrdemCompraEditaComponent } from '../ordem-compra-edita/ordem-compra-edita.component';
import { ExecucaoSimulacaoApi, CotacaoIntradayAcaoApi, OrdemCompraApi, TradeRealApi, ExecucaoSimulacao, CotacaoIntradayAcao, PeriodoExperimentoApi, PeriodoExperimento } from '../shared/sdk';
import { TradeExecucaoSimulacaoComponent } from '../trade-execucao-simulacao/trade-execucao-simulacao.component';
import { TradeRealEditaComponent } from '../trade-real-edita/trade-real-edita.component';

@Component({
  selector: 'app-valor-monitoria-periodo',
  templateUrl: './valor-monitoria-periodo.component.html',
  styleUrls: ['./valor-monitoria-periodo.component.css']
})
export class ValorMonitoriaPeriodoComponent extends BaseListComponent {

  
  private updateSubscription: Subscription;
 
  public totalExposicao;
  public exposicaoTrade;

  private idPeriodo;
  public periodo:PeriodoExperimento;

  preCarregaTela() {
    this.router.params.subscribe((params) => {
      this.idPeriodo = params['id'];
      console.log('idPeriodo:' , this.idPeriodo);
      this.srvPeriodo.findById(this.idPeriodo)
        .subscribe((result: PeriodoExperimento) => {
          console.log('periodo:' , result);
          this.periodo = result;
        })
    })

  }

  constructor(protected srv:ExecucaoSimulacaoApi, private srvCotacao: CotacaoIntradayAcaoApi,
    protected dialog: MatDialog, private srvOrdem: OrdemCompraApi, private srvTrade: TradeRealApi, 
    private router: ActivatedRoute, private srvPeriodo: PeriodoExperimentoApi) {
    super(dialog, srv)
  }

  getFiltro() {
    return { 
      'where' : {'and': [{'periodoExperimentoId' : this.idPeriodo} , {'monitorar' : 1} , {'precoEntrada' : { 'gt' : 0 }}] } , 
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
    this.carregaExposicaoTrade();
    this.carregaOrdem();
    this.updateSubscription = interval(300000)
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
  carregaExposicaoTrade() {
    this.srvTrade.TotalExposicao() 
      .subscribe((result) => {
        this.exposicaoTrade = result.valor;
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
    if (item.tipo=='C') {
      let valorEntrada = item.precoEntrada * 100;
      let valorSaida = item.precoEntrada * (1+item.target) * 100;
      return (valorSaida - valorEntrada) - CUSTO_TRADE;
    }
    if (item.tipo=='V') {
      let valorEntrada = item.precoEntrada * 100;
      let valorSaida = item.precoEntrada * (1-item.target) * 100;
      return (valorEntrada - valorSaida) - CUSTO_TRADE;
    }
    return 0;
  }
  valorSaidaPrejuizo(item:ExecucaoSimulacao) {
    if (item.tipo=='C') {
      let valorEntrada = item.precoEntrada * 100;
      let valorSaida = item.precoEntrada * (1-item.stop) * 100;
      return (valorEntrada - valorSaida) - CUSTO_TRADE;
    }
    if (item.tipo=='V') {
      let valorEntrada = item.precoEntrada * 100;
      let valorSaida = item.precoEntrada * (1+item.stop) * 100;
      return (valorSaida - valorEntrada) - CUSTO_TRADE;
    }
    return 0;

  }

  pontoSaidaLucro(item:ExecucaoSimulacao) {
    if (item.tipo=='C') {
      console.log('tipo Compra');
      let valor = item.precoEntrada * (1+item.target);
      return valor.toFixed(2);
    }
    if (item.tipo=='V') {
      console.log('tipo Venda');
      let valor = item.precoEntrada * (1-item.target);
      console.log('Entrada:' , item.precoEntrada);
      console.log('SaidaLucro:' , valor);
      return valor.toFixed(2);
    }
    return 0;
  }
  pontoSaidaPrejuizo(item:ExecucaoSimulacao) {
    if (item.tipo=='C') {
      let valor = item.precoEntrada * (1-item.stop);
      return valor.toFixed(2);
    } 
    if (item.tipo=='V') {
      let valor = item.precoEntrada * (1+item.stop);
      return valor.toFixed(2);
    } 
    return 0;

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
    if (perc<=PERCENTUAL_AVISO) {
      return 'dgc-alerta  marcatexto'
    } else {
      return '';
    }
  }
  classeStop(item) {
    let perc = this.percStop(item);
    if (perc>=(PERCENTUAL_AVISO*-1)) {
      return 'dgc-alerta'
    } else {
      return '';
    }
  }


  posicaoAtual(item) {
    if (item.valorMonitorias.length>1) {
      return item.valorMonitorias[1].posicao;
    } else {
      return 0;
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
