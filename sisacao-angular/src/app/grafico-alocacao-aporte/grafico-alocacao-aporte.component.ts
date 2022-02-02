import { Component, ViewChild } from "@angular/core";
import {
  ApexAxisChartSeries,
  ApexChart,
  ChartComponent,
  ApexDataLabels,
  ApexPlotOptions,
  ApexLegend
} from "ng-apexcharts";
import { TipoAplicacaoApi } from "../shared/sdk";

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  plotOptions: ApexPlotOptions;
  legend: ApexLegend;
  colors: string[];
};

@Component({
  selector: 'app-grafico-alocacao-aporte',
  templateUrl: './grafico-alocacao-aporte.component.html',
  styleUrls: ['./grafico-alocacao-aporte.component.css']
})
export class GraficoAlocacaoAporteComponent {
  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  dados : any[];

  inicializa() {
    this.srv.TotaisCorrenteComAporte()
      .subscribe((resultado) => {
        console.log('Resultado TipoAlocacaao: ' , resultado);
        this.dados = new Array();
        for (let i=0;i<resultado.length;i++) {
          let novoItem = {  
            x:resultado[i].nome, 
            y:resultado[i].valorTotal,
            goals:[
              {
                'name' : 'Aporte' , 
                value:resultado[i].saldoAtual,
                strokeWidth: 8,
                strokeColor: "#775DD0"
              }
            ]
          }
          this.dados.push(novoItem);
        }
        this.montaGrafico();
      })
  }

  montaGrafico() {
    console.log('Dados' , this.dados);
    this.chartOptions = {
      series: [
        {
          name: "Patrimonio",
          data: this.dados
        }
      ],
      chart: {
        height: 350,
        type: "bar"
      },
      plotOptions: {
        bar: {
          columnWidth: "60%"
        }
      },
      colors: ["#00E396"],
      dataLabels: {
        enabled: false
      },
      legend: {
        show: true,
        showForSingleSeries: true,
        customLegendItems: ["Saldo", "Aportado"],
        markers: {
          fillColors: ["#00E396", "#775DD0"]
        }
      }
    };
  }


  /*
  montaGrafico() {
    this.chartOptions = {
      series: [
        {
          name: "Actual",
          data: [
            {
              x: "2011",
              y: 1292,
              goals: [
                {
                  name: "Expected",
                  value: 1400,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            },
            {
              x: "2012",
              y: 4432,
              goals: [
                {
                  name: "Expected",
                  value: 5400,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            },
            {
              x: "2013",
              y: 5423,
              goals: [
                {
                  name: "Expected",
                  value: 5200,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            },
            {
              x: "2014",
              y: 6653,
              goals: [
                {
                  name: "Expected",
                  value: 6500,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            },
            {
              x: "2015",
              y: 8133,
              goals: [
                {
                  name: "Expected",
                  value: 6600,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            },
            {
              x: "2016",
              y: 7132,
              goals: [
                {
                  name: "Expected",
                  value: 7500,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            },
            {
              x: "2017",
              y: 7332,
              goals: [
                {
                  name: "Expected",
                  value: 8700,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            },
            {
              x: "2018",
              y: 6553,
              goals: [
                {
                  name: "Expected",
                  value: 7300,
                  strokeWidth: 5,
                  strokeColor: "#775DD0"
                }
              ]
            }
          ]
        }
      ],
      chart: {
        height: 350,
        type: "bar"
      },
      plotOptions: {
        bar: {
          columnWidth: "60%"
        }
      },
      colors: ["#00E396"],
      dataLabels: {
        enabled: false
      },
      legend: {
        show: true,
        showForSingleSeries: true,
        customLegendItems: ["Actual", "Expected"],
        markers: {
          fillColors: ["#00E396", "#775DD0"]
        }
      }
    };
  }
  */

  constructor(private srv:TipoAplicacaoApi) {
    this.inicializa();
  }
}
