import { Component, OnInit } from '@angular/core';
import { CotacaoIntradayAcaoResultado } from '../shared/sdk/models';
import { CotacaoIntradayAcaoResultadoApi } from '../shared/sdk';

@Component({
  selector: 'app-consulta-intraday-resultado-data',
  templateUrl: './consulta-intraday-resultado-data.component.html',
  styleUrls: ['./consulta-intraday-resultado-data.component.css']
})
export class ConsultaIntradayResultadoDataComponent implements OnInit {

  ticker = ''
  data = ''
  qtde = '';
  listaBase:CotacaoIntradayAcaoResultado[];
  processando = false;
  listaVaziaBol = false;

  maiorValor = 0
  menorValor = Infinity;

  constructor(private srv:CotacaoIntradayAcaoResultadoApi) { }

  ngOnInit() {
    
  }

  onSubmit() {
    this.listaVaziaBol = false;
    this.processando = true;
    this.listaBase = null;
    this.carregaCotacao();
  }

  carregaCotacao() {
    let filtro = {
      'where' : {
        'and' : [
          {'ticker' : this.ticker},
          {'gte' : {'diaNum' : this.data} }
        ]
      },
      'limit' : this.qtde
    }
    this.srv.find(filtro)
      .subscribe((result:CotacaoIntradayAcaoResultado[]) => {
        for (const cotacao of result) {
          if (cotacao.valor < this.menorValor) {
            this.menorValor = cotacao.valor;
          }
          if (cotacao.valor > this.maiorValor) {
            this.maiorValor = cotacao.valor;
          }
        }

        this.listaBase = result;
      })
  }

}
