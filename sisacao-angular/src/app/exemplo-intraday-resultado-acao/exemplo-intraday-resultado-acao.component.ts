import { Component, OnInit } from '@angular/core';
import { CotacaoDiarioAcao, CotacaoDiarioAcaoApi, CotacaoIntradayAcaoResultado, CotacaoIntradayAcaoResultadoApi, ExemploTreinoAcao, ExemploTreinoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-exemplo-intraday-resultado-acao',
  templateUrl: './exemplo-intraday-resultado-acao.component.html',
  styleUrls: ['./exemplo-intraday-resultado-acao.component.css']
})
export class ExemploIntradayResultadoAcaoComponent implements OnInit {

  ticker = ''
  data = ''

  exemplo:ExemploTreinoAcao;
  listaValor:string[];
  listaBase:CotacaoIntradayAcaoResultado[];
  diaPrevisao:CotacaoDiarioAcao;

  diaSaida: CotacaoDiarioAcao;
  limiteSaida : any;

  constructor(private srv :ExemploTreinoAcaoApi, 
      private srvCotacao :CotacaoIntradayAcaoResultadoApi, private srvDiario:CotacaoDiarioAcaoApi) { }

  ngOnInit() {
  }


  onSubmit() {
    this.carregaExemplo();
    this.carregaDiario();
  }




  getValor(posicao) {
    if (posicao<=this.listaValor.length)
      return this.listaValor[posicao];
    else  
      return "-";
  }

  carregaDiario() {
    let filtro = {
      'where' : {
        'and' : [
          {'ticker' : this.ticker},
          {'diaNum' : this.data}
        ]
      }
    }
    this.srvDiario.findOne(filtro)
      .subscribe((result:CotacaoDiarioAcao) => {
        this.diaPrevisao = result;
        console.log('Dia Previsao:', this.diaPrevisao);
      })
  }

  carregaDiarioSaida() {
    let filtro = {
      'where' : {
        'and' : [
          {'ticker' : this.ticker},
          {'diaNum' : this.exemplo.diaNumSaida}
        ]
      }
    }
    this.srvDiario.findOne(filtro)
      .subscribe((result:CotacaoDiarioAcao) => {
        this.diaSaida = result;
        console.log('Dia Saída:', this.diaSaida);
      })
  }
  carregaLimiteDiario() {
    this.srvDiario.LimitesPeriodo(this.ticker,this.exemplo.diaNumPrevisao,this.exemplo.diaNumSaida)
      .subscribe((result) => {
        console.log('Limites:' , result);
        this.limiteSaida = result;
      })
  }

  carregaExemplo() {
    let filtro = {
        'where' : {
          'and' : [ 
            {'ticker' : this.ticker} , 
            {'diaNumPrevisao' : this.data }
          ] 
        }
    };
    this.srv.findOne(filtro)
      .subscribe((result:ExemploTreinoAcao) => {
        console.log('exemplo:' , result);
        this.exemplo = result;
        this.listaValor = this.exemplo.campoX.split(',');
        console.log('listaValor:' , this.listaValor);
        this.carregaIntraday();
        if (this.exemplo.diaNumSaida) {
          this.carregaDiarioSaida();
          this.carregaLimiteDiario();
        }
      })
  }
  carregaIntraday() {
    let filtro = {
        'where' : {
          'and' : [ 
            {'ticker' : this.ticker} , 
            {'diaNum' : {'gte' : this.exemplo.diaNumInicio }} 
          ] ,
          'order' : 'dataHora asc',
          'limit' : 80
        }
    };
    this.srvCotacao.find(filtro)
      .subscribe((result:CotacaoIntradayAcaoResultado[]) => {
        this.listaBase = result;
        console.log('listaBase:' , this.listaBase);
      })
  }


}
