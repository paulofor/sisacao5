import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { Subscription, interval } from 'rxjs';
import { CotacaoIntradayAcao, CotacaoIntradayIndice, CotacaoIntradayIndiceApi} from '../shared/sdk';

import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexTitleSubtitle,
  ApexStroke,
  ApexGrid
} from "ng-apexcharts";

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  dataLabels: ApexDataLabels;
  grid: ApexGrid;
  stroke: ApexStroke;
  title: ApexTitleSubtitle;
};


@Component({
  selector: 'app-item-visual-indice',
  templateUrl: './item-visual-indice.component.html',
  styleUrls: ['./item-visual-indice.component.css']
})
export class ItemVisualIndiceComponent implements OnInit {

  private updateSubscription: Subscription;

  @Input() ticker: any;
  listaCotacao: CotacaoIntradayIndice[];
  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  dados: any[];
  rotulos: any[];


  constructor(private srvCotacao:CotacaoIntradayIndiceApi) { }

  DIAS = 5;


  ngOnInit() {
    //this.carregaEntrada();
    console.log('TickerIbov: ' , this.ticker);
    this.carregaPrecoAtual();
    this.updateSubscription = interval(300000)
    .subscribe((val) => { 
      this.carregaPrecoAtual()
    });
  }



  getDataHoraUlt() {
    let valor:string = this.listaCotacao[0].dataHora.toString();
    return "(" + valor.substring(11,16) + ")";
  }



  carregaPrecoAtual() {
    let pontos = 51 * this.DIAS;
    this.srvCotacao.AtualIndicePorTicker(this.ticker,pontos)
      .subscribe((result:CotacaoIntradayAcao[]) => {
        console.log('Indice:' , result);
        this.listaCotacao = result;
        this.dados = new Array();
        this.rotulos = new Array();
        for (let x=this.listaCotacao.length-1;x>=0;x--) {
          this.dados.push(this.listaCotacao[x].valor);
          this.rotulos.push(x);
        }
        this.montaGrafico();
      })
  }

  montaGrafico() {
    this.chartOptions = {
      series: [
        {
          name: "Preço",
          data: this.dados
        }
        
      ],
      chart: {
        height: 330,
        type: "line",
        zoom: {
          enabled: false
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        curve: "straight"
      },
      title: {
        text: "",
        align: "left"
      },
      grid: {
        row: {
          colors: ["#f3f3f3", "transparent"], // takes an array which will be repeated on columns
          opacity: 0.5
        }
      },
      xaxis: {
        categories: this.rotulos
      }
    };
  }

}