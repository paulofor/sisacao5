import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoIntradayFoxbit, CotacaoIntradayFoxbitApi } from '../shared/sdk';

@Component({
  selector: 'app-cotacao-intra-criptomoeda',
  templateUrl: './cotacao-intra-criptomoeda.component.html',
  styleUrls: ['./cotacao-intra-criptomoeda.component.css']
})
export class CotacaoIntraCriptomoedaComponent implements OnInit {

  lista: CotacaoIntradayFoxbit[];
  ticker: string;

  constructor(private srv: CotacaoIntradayFoxbitApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': 
            {'and' : [{ 'ticker': this.ticker }, {'cambio' : 'foxbit'}] }, 
            'order': 'dataHora DESC' , 
            'limit' : 600 
          }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayFoxbit[]) => {
          this.lista = result;
        })
    })
  }

}
