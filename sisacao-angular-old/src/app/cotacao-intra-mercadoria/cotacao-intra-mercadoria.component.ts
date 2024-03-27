import { Component, OnInit } from '@angular/core';
import { CotacaoIntradayMercadoria, CotacaoIntradayMercadoriaApi } from '../shared/sdk';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cotacao-intra-mercadoria',
  templateUrl: './cotacao-intra-mercadoria.component.html',
  styleUrls: ['./cotacao-intra-mercadoria.component.css']
})
export class CotacaoIntraMercadoriaComponent implements OnInit {

  lista: CotacaoIntradayMercadoria[];
  ticker: string;

  constructor(private srv: CotacaoIntradayMercadoriaApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': { 'ticker': this.ticker }, 'order': 'dataHora DESC' , 'limit' : 600 }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayMercadoria[]) => {
          this.lista = result;
        })
    })
  }

}
