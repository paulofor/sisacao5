import { Component, OnInit } from '@angular/core';
import { CotacaoIntradayAcaoApi, CotacaoIntradayAcao } from '../shared/sdk';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cotacao-intra-acao',
  templateUrl: './cotacao-intra-acao.component.html',
  styleUrls: ['./cotacao-intra-acao.component.css']
})
export class CotacaoIntraAcaoComponent implements OnInit {

  lista: CotacaoIntradayAcao[];
  ticker: string;
  hoje : Date = new Date();

  constructor(private srv: CotacaoIntradayAcaoApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': { 'ticker': this.ticker }, 'order': 'dataHora DESC' , 'limit' : 600 }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayAcao[]) => {
          this.lista = result;
        })
    })
  }

}
