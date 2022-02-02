import { Component, Input, OnInit, ViewChild } from "@angular/core";

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
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, Trade, TradeReal } from '../shared/sdk';

@Component({
  selector: 'app-item-trade-real-visual',
  templateUrl: './item-trade-real-visual.component.html',
  styleUrls: ['./item-trade-real-visual.component.css']
})
export class ItemTradeRealVisualComponent implements OnInit {

  @Input() trade: any;
  listaCotacao: CotacaoIntradayAcao[];
  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  dados: any[];
  rotulos: any[];

  constructor(private srvCotacao:CotacaoIntradayAcaoApi) { }

  ngOnInit() {
    this.carregaPrecoAtual()
    
  }

  carregaPrecoAtual() {
    this.srvCotacao.AtualPorTicker(this.trade.ticker,16)
      .subscribe((result:CotacaoIntradayAcao[]) => {
        this.listaCotacao = result;
        console.log('cotacao:' , this.listaCotacao);
        this.dados = new Array();
        this.rotulos = new Array();
        for (let x=this.listaCotacao.length-1;x>=0;x--) {
          this.dados.push(this.listaCotacao[x].valor);
          this.rotulos.push(this.listaCotacao[x].dataHora);
        }
        this.montaGrafico();
      })
  }

  montaGrafico() {
    this.chartOptions = {
      series: [
        {
          name: "Desktops",
          data: this.dados
        }
      ],
      chart: {
        height: 350,
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
        categories: []
      }
    };
  }

}





