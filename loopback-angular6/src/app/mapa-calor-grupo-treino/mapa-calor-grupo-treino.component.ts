import { Component, OnInit, ViewChild } from '@angular/core';


import {
  ApexAxisChartSeries,
  ApexTitleSubtitle,
  ApexDataLabels,
  ChartComponent,
  ApexChart
} from "ng-apexcharts";
import { RegraProjecao, RegraProjecaoApi } from '../shared/sdk';

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  title: ApexTitleSubtitle;
  colors: any;
};


@Component({
  selector: 'app-mapa-calor-grupo-treino',
  templateUrl: './mapa-calor-grupo-treino.component.html',
  styleUrls: ['./mapa-calor-grupo-treino.component.css']
})
export class MapaCalorGrupoTreinoComponent implements OnInit {

  ngOnInit() {}
  constructor() {}

  /*
  listaBase : RegraProjecao[];
  dadosGrafico: any[];

  ngOnInit() {
    let filtro = {
      'where' : { 'and' : [{'diaLimite':50} , {'tipoCompraVenda' : 'V'} , {'percentualEntradaDataset' : 0.02}] } , 
      'order' : ['target' , 'stop'],
      'include' : {'relation' : 'treinoRedes' , 'scope' : {
        'where' : {'treinoGrupoRedeId' : 1}
      }}
    }
    this.srv.find(filtro)
      .subscribe((result : RegraProjecao[]) => {
        console.log('resultado:' , result);
        this.listaBase = result;
        this.montaDadosPontos();
        this.montaGrafico();
      })
  }

  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  constructor(private srv: RegraProjecaoApi) {
   
  }

  montaGrafico() {
    this.chartOptions = {
      series:this.dadosGrafico,
      chart: {
        height: 280,
        width: 320,
        type: "heatmap"
      },
      dataLabels: {
        enabled: false
      },
      colors: ["#008FFB"],
      title: {
        text: "Compra - p0"
      }
    };
  }

  montaDadosPontos() {
    let v0 = this.listaBase[0].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v1 = this.listaBase[1].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v2 = this.listaBase[2].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v3 = this.listaBase[3].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v4 = this.listaBase[4].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v5 = this.listaBase[5].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v6 = this.listaBase[6].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v7 = this.listaBase[7].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    let v8 = this.listaBase[8].treinoRedes[0].pontuacaoTeste + this.listaBase[0].treinoRedes[1].pontuacaoTeste
    this.dadosGrafico = [
      {
        name: "Target-9",
        data: [{'x' : 'Stop-9' , 'y' : v0} , {'x' : 'Stop-13' , 'y' : v1}, {'x' : 'Stop-17' , 'y' : v2}]
      },
      {
        name: "Target-13",
        data:[{'x' : 'Stop-9' , 'y' : v3} , {'x' : 'Stop-13' , 'y' : v4}, {'x' : 'Stop-17' , 'y' : v5}]
      },
      {
        name: "Target-17",
        data:[{'x' : 'Stop-9' , 'y' : v6} , {'x' : 'Stop-13' , 'y' : v7}, {'x' : 'Stop-17' , 'y' : v8}]
      }
    ]
  }


  montaDados() {
    this.dadosGrafico = [
      {
        name: "Target-9",
        data: [{'x' : 'Stop-9' , 'y' : (-18-18)} , {'x' : 'Stop-13' , 'y' : (-2-31)}, {'x' : 'Stop-17' , 'y' : (-64-28)}]
      },
      {
        name: "Target-13",
        data:[{'x' : 'Stop-9' , 'y' : (-46-16)} , {'x' : 'Stop-13' , 'y' : (-65-13)}, {'x' : 'Stop-17' , 'y' : (-46-7)}]
      },
      {
        name: "Target-17",
        data:[{'x' : 'Stop-9' , 'y' : (-36-64)} , {'x' : 'Stop-13' , 'y' : (-65-57)}, {'x' : 'Stop-17' , 'y' : (-34-51)}]
      }
    ]
  }  
  */
}
