import { Component, OnInit } from '@angular/core';
import { CotacaoIntradayOpcao, CotacaoIntradayOpcaoApi } from '../shared/sdk';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cotacao-intra-opcao',
  templateUrl: './cotacao-intra-opcao.component.html',
  styleUrls: ['./cotacao-intra-opcao.component.css']
})
export class CotacaoIntraOpcaoComponent implements OnInit {

  lista: CotacaoIntradayOpcao[];
  ticker: string;

  constructor(private srv: CotacaoIntradayOpcaoApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': { 'ticker': this.ticker }, 'order': 'dataHora DESC' , 'limit' : 600 }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayOpcao[]) => {
          this.lista = result;
        })
    })
  }

}
