import { Component, OnInit } from '@angular/core';
import { TradeRealApi } from '../shared/sdk';

@Component({
  selector: 'app-resumo-trade-real',
  templateUrl: './resumo-trade-real.component.html',
  styleUrls: ['./resumo-trade-real.component.css']
})
export class ResumoTradeRealComponent implements OnInit {

  listaResumoTrade: any[];

  valor1Mes:number;
  valor3Meses: number;
  valor6Meses: number;
  valor12Meses: number;

  constructor(private srv: TradeRealApi) { }

  ngOnInit() {
    this.carregaResumoTrade();
    this.carregaListaTrade();
  }

  carregaResumoTrade() {
    this.srv.ResultadoPorMes(13)
      .subscribe((resultado) => {
        console.log('Resultado por mes' , resultado);
        this.listaResumoTrade = resultado;
      })
  }

  carregaListaTrade() {

  }

}
