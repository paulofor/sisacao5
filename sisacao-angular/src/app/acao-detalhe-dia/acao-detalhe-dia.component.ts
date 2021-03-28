import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoDiarioAcao, CotacaoDiarioAcaoApi, CotacaoIntradayAcao, CotacaoIntradayAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-acao-detalhe-dia',
  templateUrl: './acao-detalhe-dia.component.html',
  styleUrls: ['./acao-detalhe-dia.component.css']
})
export class AcaoDetalheDiaComponent implements OnInit {

  lista: CotacaoIntradayAcao[];
  ticker: string;
  diaNum: number;
  cotacao: CotacaoDiarioAcao;

  constructor(private srv: CotacaoIntradayAcaoApi, private router: ActivatedRoute, private srvDiario: CotacaoDiarioAcaoApi) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['ticker'];
      this.diaNum = params['diaNum'];
      let filtro = { 'where': {'and' : [ {'ticker': this.ticker }, {'diaNum' : this.diaNum} ]}, 'order': 'dataHora ASC' }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayAcao[]) => {
          this.lista = result;
        });
      let filtroDiario = { 'where': {'and' : [ {'ticker': this.ticker }, {'diaNum' : this.diaNum} ]}};
      this.srvDiario.findOne(filtroDiario)
        .subscribe((result: CotacaoDiarioAcao) => {
          console.log('Result: ', result);
          this.cotacao = result;
      });
    })
  }

}
