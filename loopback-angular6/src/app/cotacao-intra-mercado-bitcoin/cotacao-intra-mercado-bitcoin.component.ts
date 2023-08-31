import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoIntradayMercadoBitcoin, CotacaoIntradayMercadoBitcoinApi } from '../shared/sdk';

@Component({
  selector: 'app-cotacao-intra-mercado-bitcoin',
  templateUrl: './cotacao-intra-mercado-bitcoin.component.html',
  styleUrls: ['./cotacao-intra-mercado-bitcoin.component.css']
})
export class CotacaoIntraMercadoBitcoinComponent implements OnInit {

  lista: CotacaoIntradayMercadoBitcoin[];
  ticker: string;

  constructor(private srv: CotacaoIntradayMercadoBitcoinApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': { 'ticker': this.ticker }, 
            'order': 'dataHora DESC' , 
            'limit' : 600 
          }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayMercadoBitcoin[]) => {
          this.lista = result;
        })
    })
  }

  getData(item) {
    var d = new Date(item.dataInt * 1000);
    return d;
  }

}
