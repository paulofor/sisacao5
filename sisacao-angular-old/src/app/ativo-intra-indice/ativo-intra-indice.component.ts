import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoIntradayIndice, CotacaoIntradayIndiceApi } from '../shared/sdk';

@Component({
  selector: 'app-ativo-intra-indice',
  templateUrl: './ativo-intra-indice.component.html',
  styleUrls: ['./ativo-intra-indice.component.css']
})
export class AtivoIntraIndiceComponent implements OnInit {

  lista: CotacaoIntradayIndice[];
  ticker: string;

  constructor(private srv: CotacaoIntradayIndiceApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaIntra();
  }

  carregaIntra() {
    this.router.params.subscribe((params) => {
      this.ticker = params['id'];
      let filtro = { 'where': { 'ticker': this.ticker }, 'order': 'dataHora DESC' , 'limit' : 600 }
      this.srv.find(filtro)
        .subscribe((result: CotacaoIntradayIndice[]) => {
          console.log('Intra Indice: ' , result);
          this.lista = result;
        })
    })
  }

}
