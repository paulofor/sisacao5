import { Component, OnInit } from '@angular/core';
import { CotacaoIntradayAcaoApi, CotacaoIntradayAcaoResultado, CotacaoIntradayAcaoResultadoApi } from '../shared/sdk';

@Component({
  selector: 'app-cotacao-intraday-resultado-acao',
  templateUrl: './cotacao-intraday-resultado-acao.component.html',
  styleUrls: ['./cotacao-intraday-resultado-acao.component.css']
})
export class CotacaoIntradayResultadoAcaoComponent implements OnInit {

  ticker = ''
  data = ''
  listaBase:CotacaoIntradayAcaoResultado[];

  constructor(private srv :CotacaoIntradayAcaoResultadoApi) { }

  ngOnInit() {
  }


  onSubmit() {
    console.log('ticker:' , this.ticker);
    console.log('data:' , this.data);
    let filtro = {
        'where' : {
          'and' : [ 
            {'ticker' : this.ticker} , 
            {'diaNum' : {'lte' : this.data }} 
          ] ,
          'order' : 'dataHora desc',
          'limit' : 80
        }
    };
    this.srv.find(filtro)
      .subscribe((result:CotacaoIntradayAcaoResultado[]) => {
        this.listaBase = result;
      })
  }


}
