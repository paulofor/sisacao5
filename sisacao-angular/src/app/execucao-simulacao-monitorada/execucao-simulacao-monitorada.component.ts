import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, ExecucaoSimulacao, ExecucaoSimulacaoApi } from '../shared/sdk';
import { TradeExecucaoSimulacaoComponent } from '../trade-execucao-simulacao/trade-execucao-simulacao.component';

@Component({
  selector: 'app-execucao-simulacao-monitorada',
  templateUrl: './execucao-simulacao-monitorada.component.html',
  styleUrls: ['./execucao-simulacao-monitorada.component.css']
})
export class ExecucaoSimulacaoMonitoradaComponent extends BaseListComponent{

  constructor(protected srv:ExecucaoSimulacaoApi, private srvCotacao: CotacaoIntradayAcaoApi,
    protected dialog: MatDialog) {
    super(dialog, srv)
  }

  getFiltro() {
    return {'where' : {'monitorar' : 1} , 'order' : 'resultado desc'}
  }

  getValorLucro(item:ExecucaoSimulacao) {

  }

  getValorPrejuizo(item:ExecucaoSimulacao) {
    
  }

  posCarregaLista() {
    this.listaBase.forEach((execucao:ExecucaoSimulacao) => {
      this.srvCotacao.AtualPorTicker(execucao.ticker,1)
        .subscribe((cotacao:CotacaoIntradayAcao[]) => {
          execucao['precoAtual'] = cotacao[0].valor;
        })
    })
  }

  classePreco(item:ExecucaoSimulacao) {
    if (item['precoAtual'] < item.precoEntrada)
      return "entrada"
    else
      return ""
  }

  valorSaidaLucro(item:ExecucaoSimulacao) {
    let valorEntrada = item.precoEntrada * 100;
    let valorSaida = item.precoEntrada * (1+item.target) * 100;
    return valorSaida - valorEntrada;
  }
  valorSaidaPrejuizo(item:ExecucaoSimulacao) {
    let valorEntrada = item.precoEntrada * 100;
    let valorSaida = item.precoEntrada * (1-item.stop) * 100;
    return valorEntrada - valorSaida;
  }

  pontoSaidaLucro(item:ExecucaoSimulacao) {
    return item.precoEntrada * (1+item.target);
  }
  pontoSaidaPrejuizo(item:ExecucaoSimulacao) {
    return item.precoEntrada * (1-item.stop);
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
