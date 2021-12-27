import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, CotacaoIntradayFoxbit, CotacaoIntradayFoxbitApi } from '../shared/sdk';

@Component({
  selector: 'app-cotacao-intraday-recente',
  templateUrl: './cotacao-intraday-recente.component.html',
  styleUrls: ['./cotacao-intraday-recente.component.css']
})
export class CotacaoIntradayRecenteComponent implements OnInit {

  listaFoxbit : CotacaoIntradayFoxbit[];
  lista: CotacaoIntradayAcao[];
  ticker: string;

  constructor(private srv: CotacaoIntradayAcaoApi, private srvCripto: CotacaoIntradayFoxbitApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    let filtro = { 'order': 'dataHora DESC' , 'limit' : 10 }
    this.srv.find(filtro)
      .subscribe((result: CotacaoIntradayAcao[]) => {
        console.log('ListaSimples: ' , result)
        this.lista = result;
      })
    this.srvCripto.find(filtro)
      .subscribe((result: CotacaoIntradayFoxbit[]) => {
        console.log('ListaCripto: ' , result)
        this.listaFoxbit = result;
      })
  }
}
