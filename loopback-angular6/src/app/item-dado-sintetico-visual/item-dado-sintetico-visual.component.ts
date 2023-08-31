import { Component, Input, OnInit, ViewChild } from "@angular/core";
import { DISABLED } from "@angular/forms/src/model";



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
import { Subscription, interval } from "rxjs";
import { PERCENTUAL_AVISO } from "../constantes/base.url";


export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  dataLabels: ApexDataLabels;
  grid: ApexGrid;
  stroke: ApexStroke;
  title: ApexTitleSubtitle;
};
import { CotacaoIntradayAcao, CotacaoIntradayAcaoApi, ExecucaoSimulacaoApi, Trade, TradeReal } from '../shared/sdk';

@Component({
  selector: 'app-item-dado-sintetico-visual',
  templateUrl: './item-dado-sintetico-visual.component.html',
  styleUrls: ['./item-dado-sintetico-visual.component.css']
})
export class ItemDadoSinteticoVisualComponent implements OnInit {

  private updateSubscription: Subscription;

  @Input() item: any;
  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  dados: any[];
  rotulos: any[];

  dados2 : any[];

  maiorOriginal:number;
  menorOriginal:number;

  constructor() { }



  ngOnInit() {
    console.log('item-grafico:' , this.item);
    this.carregaPrecoAtual();
  }


  carregaPrecoAtual() {
    this.dados = this.item.campoXOriginal.split(",").map(parseFloat);
    this.dados2 = this.item.campoX.split(",").map(parseFloat);
    this.maiorOriginal = Math.max(...this.dados);
    console.log('maior' , this.maiorOriginal);
    this.menorOriginal = Math.min(...this.dados);
    this.montaGrafico();
  }

  montaGrafico() {
    this.chartOptions = {
      series: [
        {
          name: "Preço",
          data: this.dados2
        }
      ],
      chart: {
        height: 280,
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
      }
    };
  }

}







