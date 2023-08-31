import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoDiarioAcao, CotacaoDiarioAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-cotacao-diario-acao',
  templateUrl: './cotacao-diario-acao.component.html',
  styleUrls: ['./cotacao-diario-acao.component.css']
})
export class CotacaoDiarioAcaoComponent implements OnInit {

  lista: CotacaoDiarioAcao[];
  ticker: string;

  constructor(private srv: CotacaoDiarioAcaoApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': { 'ticker': this.ticker }, 'order': 'data DESC' , 'limit' : 100 }
      this.srv.find(filtro)
        .subscribe((result: CotacaoDiarioAcao[]) => {
          this.lista = result;
        })
    })
  }

}
