import { Component, OnInit } from '@angular/core';
import { TradeReal, TradeRealApi } from '../shared/sdk';

@Component({
  selector: 'app-resumo-trade-real',
  templateUrl: './resumo-trade-real.component.html',
  styleUrls: ['./resumo-trade-real.component.css']
})
export class ResumoTradeRealComponent implements OnInit {

  listaResumoTrade: any[];
  listaTrade:TradeReal[];

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

  reprocessar(item) {
    this.srv.CalculaSaida(item.id)
      .subscribe((result) => {
        this.ngOnInit();
      })
  }

  carregaListaTrade() {
    let filtro = {
      'order' : 'dataSaida desc',
      'where' : {'dataSaida' : {'neq' : null}}
    }
    this.srv.find(filtro)
      .subscribe((resultado:TradeReal[]) => {
        console.log('ListaTrade:' , resultado);
        this.listaTrade = resultado;
      })
  }

  total() {
    let total = 0;
    for (let i=0;i<this.listaTrade.length;i++) {
      total+= this.listaTrade[i].lucroPrejuizo;
    }
    return total
  }

  soma(meses) {
    let total = 0;
    for (let i=0;i<this.listaResumoTrade.length && i<meses;i++) {
      total+= this.listaResumoTrade[i].lucroPrejuizo;
    }
    return total
  }

}
