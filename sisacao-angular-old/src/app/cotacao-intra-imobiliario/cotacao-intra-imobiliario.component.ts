import { Component, OnInit } from '@angular/core';
import { CotacaoIntradayImobiliario, CotacaoIntradayImobiliarioApi } from '../shared/sdk';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cotacao-intra-imobiliario',
  templateUrl: './cotacao-intra-imobiliario.component.html',
  styleUrls: ['./cotacao-intra-imobiliario.component.css']
})
export class CotacaoIntraImobiliarioComponent implements OnInit {

  lista: CotacaoIntradayImobiliario[];
  ticker: string;

  constructor(private srv: CotacaoIntradayImobiliarioApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': { 'ticker': this.ticker }, 'order': 'dataHora DESC' , 'limit' : 600 }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayImobiliario[]) => {
          this.lista = result;
        })
    })
  }


}
