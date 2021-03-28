import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-cotacao-intraday-recente',
  templateUrl: './cotacao-intraday-recente.component.html',
  styleUrls: ['./cotacao-intraday-recente.component.css']
})
export class CotacaoIntradayRecenteComponent implements OnInit {

  lista: CotacaoIntradayAcao[];
  ticker: string;

  constructor(private srv: CotacaoIntradayAcaoApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    let filtro = { 'order': 'dataHora DESC' , 'limit' : 10 }
    this.srv.find(filtro)
      .subscribe((result: CotacaoIntradayAcao[]) => {
        this.lista = result;
      })
  }
}
