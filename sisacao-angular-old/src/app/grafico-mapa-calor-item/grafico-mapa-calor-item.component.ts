import { Component, Input, OnInit, ViewChild } from '@angular/core';


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
  selector: 'app-grafico-mapa-calor-item',
  templateUrl: './grafico-mapa-calor-item.component.html',
  styleUrls: ['./grafico-mapa-calor-item.component.css']
})
export class GraficoMapaCalorItemComponent implements OnInit {

  listaBase: RegraProjecao[];
  dadosGrafico: any[];


  @Input() diaLimite: number;
  @Input() numCompraVenda: number;
  @Input() percentualEntradaDataset: number;
  
  tipoCompraVenda: string


  ngOnInit() {
    if (this.numCompraVenda==1) this.tipoCompraVenda = 'C'
    if (this.numCompraVenda==-1) this.tipoCompraVenda = 'V'
    let filtro = {
      'where': { 'and': [
            { 'diaLimite': this.diaLimite }, 
            { 'tipoCompraVenda': this.tipoCompraVenda }, 
            { 'percentualEntradaDataset': this.percentualEntradaDataset }
          ] },
      'order': ['target', 'stop'],
      'include': {
        'relation': 'treinoRedes', 'scope': {
          'where': { 'treinoGrupoRedeId': 1 }
        }
      }
    }
    console.log('filtro:' , filtro);
    this.srv.find(filtro)
      .subscribe((result: RegraProjecao[]) => {
        console.log('resultado:', result);
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
      series: this.dadosGrafico,
      chart: {
        height: 250,
        width: 450,
        type: "heatmap"
      },
      dataLabels: {
        enabled: false
      },
      colors: ["#008FFB"],
      title: {
        text:  this.tipoCompraVenda + "_" + this.percentualEntradaDataset
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
    let target09 = 'Target-9 (' + (v0+v1+v2) + ')'
    let target13 = 'Target-13 (' + (v3+v4+v5) + ')'
    let target17 = 'Target-17 (' + (v6+v7+v8) + ')'
    let stop09 = 'Stop-9 (' + (v0+v3+v6) + ')'
    let stop13 = 'Stop-13 (' + (v1+v4+v7) + ')'
    let stop17 = 'Stop-17 (' + (v2+v5+v8) + ')'
    this.dadosGrafico = [
      {
        name: stop09,
        data: [{ 'x': target09, 'y': v0 }, { 'x': target13, 'y': v3 }, { 'x': target17, 'y': v6 }]
      },
      {
        name: stop13,
        data: [{ 'x': target09, 'y': v1 }, { 'x': target13, 'y': v4 }, { 'x': target17, 'y': v7 }]
      },
      {
        name: stop17,
        data: [{ 'x': target09, 'y': v2 }, { 'x': target13, 'y': v5 }, { 'x': target17, 'y': v8 }]
      }
    ]
  }

}
