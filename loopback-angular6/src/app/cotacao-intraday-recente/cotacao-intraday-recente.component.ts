import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, CotacaoIntradayCoinmarketcap, CotacaoIntradayCoinmarketcapApi, CotacaoIntradayFoxbit, CotacaoIntradayFoxbitApi, CotacaoIntradayImobiliario, CotacaoIntradayImobiliarioApi, CotacaoIntradayIndice, CotacaoIntradayIndiceApi, CotacaoIntradayMercadoBitcoin, CotacaoIntradayMercadoBitcoinApi } from '../shared/sdk';

@Component({
  selector: 'app-cotacao-intraday-recente',
  templateUrl: './cotacao-intraday-recente.component.html',
  styleUrls: ['./cotacao-intraday-recente.component.css']
})
export class CotacaoIntradayRecenteComponent implements OnInit {

  listaFoxbit : CotacaoIntradayFoxbit[];
  listaMercadoBitcoin : CotacaoIntradayMercadoBitcoin[];
  lista: CotacaoIntradayAcao[];
  listaIndice : CotacaoIntradayIndice[];
  //listaImobiliario : CotacaoIntradayImobiliario[]
  listaCripto: CotacaoIntradayCoinmarketcap[];
  ticker: string;

  constructor(private srv: CotacaoIntradayAcaoApi, private srvCripto: CotacaoIntradayFoxbitApi, 
      private srvIndice: CotacaoIntradayIndiceApi, private srvImobiliario: CotacaoIntradayImobiliarioApi,
      private srvCoinMarketcap:CotacaoIntradayCoinmarketcapApi, 
      private srvMB: CotacaoIntradayMercadoBitcoinApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    let filtro = { 'order': 'dataHora DESC', 'limit': 3 }
    this.srv.find(filtro)
      .subscribe((result: CotacaoIntradayAcao[]) => {
        //console.log('ListaSimples: ', result)
        this.lista = result;
      })
    this.srvCripto.find(filtro)
      .subscribe((result: CotacaoIntradayFoxbit[]) => {
        //console.log('ListaCripto: ', result)
        this.listaFoxbit = result;
      })
    this.srvMB.find(filtro)
      .subscribe((result: CotacaoIntradayMercadoBitcoin[]) => {
        //console.log('ListaMercadoBitcoin: ', result)
        this.listaMercadoBitcoin = result;
      })
    this.srvIndice.find(filtro)
      .subscribe((result: CotacaoIntradayIndice[]) => {
        //console.log('ListaMercadoBitcoin: ', result)
        this.listaIndice = result;
      })
    this.srvCoinMarketcap.find(filtro)
      .subscribe((result: CotacaoIntradayCoinmarketcap[]) => {
        //console.log('ListaMercadoBitcoin: ', result)
        this.listaCripto = result;
      })
  }
}
