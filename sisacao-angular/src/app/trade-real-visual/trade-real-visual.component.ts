import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { interval, Subscription } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { TradeRealApi, CotacaoIntradayAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-trade-real-visual',
  templateUrl: './trade-real-visual.component.html',
  styleUrls: ['./trade-real-visual.component.css']
})
export class TradeRealVisualComponent extends BaseListComponent {

  resultadoAtual: number;
  exposicao: number;
  private updateSubscription: Subscription;
  indice = 'ibov';

  constructor(protected dialog: MatDialog, protected srv:TradeRealApi, private srvCotacao: CotacaoIntradayAcaoApi) { 
    super(dialog,srv);
  }

  classeSaldo() {
    if (this.resultadoAtual > 0) return 'dgc-lucro';
    if (this.resultadoAtual < 0) return 'dgc-prejuizo';
    return '';
  }

  preCarregaTela() {
    this.carregaValorAtual();
    this.updateSubscription = interval(300000)
    .subscribe((val) => { 
      this.carregaValorAtual()
    });
    this.srv.RiscoAtual()
      .subscribe((result) => {
        console.log('RiscoAtual' , result);
        this.exposicao = result.valor;
      })
  }
  carregaValorAtual() {
    this.srv.SituacaoAtual()
    .subscribe((result) => {
      this.resultadoAtual = result.valor;
    });
  }

  getFiltro() {
    return {
      'where' : {'posicaoAtual' : {'neq' : 0}},
      'order' : 'dataEntrada desc',
      'include' : [
          {'relation' : 'execucaoSimulacao'},
          {'relation' : 'ativoAcao' }
      ]
    }
  }
}
