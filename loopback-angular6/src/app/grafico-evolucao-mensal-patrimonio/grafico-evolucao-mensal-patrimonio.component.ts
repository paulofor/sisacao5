import { Component, OnInit, ViewChild } from '@angular/core';
import {
  ApexAxisChartSeries,
  ApexChart,
  ChartComponent,
  ApexDataLabels,
  ApexPlotOptions,
  ApexYAxis,
  ApexLegend,
  ApexStroke,
  ApexXAxis,
  ApexFill,
  ApexTooltip
} from "ng-apexcharts";
import { TipoAplicacao, TipoAplicacaoApi } from '../shared/sdk';
import { TipoAplicacaoSaldoMesApi } from '../shared/sdk/services/custom/TipoAplicacaoSaldoMes';

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  plotOptions: ApexPlotOptions;
  yaxis: ApexYAxis;
  xaxis: ApexXAxis;
  fill: ApexFill;
  tooltip: ApexTooltip;
  stroke: ApexStroke;
  legend: ApexLegend;
};
@Component({
  selector: 'app-grafico-evolucao-mensal-patrimonio',
  templateUrl: './grafico-evolucao-mensal-patrimonio.component.html',
  styleUrls: ['./grafico-evolucao-mensal-patrimonio.component.css']
})
export class GraficoEvolucaoMensalPatrimonioComponent implements OnInit {

  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  serie: any[];

  ngOnInit() {
    let filtro = {'include' : {'relation' : 'tipoAplicacaoSaldoMes' , 'scope' : {
      'order' : 'diaNumReferencia'
    }}}
    this.srv.find(filtro)
      .subscribe((resultado : TipoAplicacao[]) => {
        console.log('ListaGrafico' , resultado);
        this.serie = [];
        for (let i=0;i<resultado.length;i++) {
          let tipo = resultado[i];
          let item = {'name' : tipo.nome , 'data' : []}
          for (let x=0;x<tipo.tipoAplicacaoSaldoMes.length;x++) {
            let saldoMes = tipo.tipoAplicacaoSaldoMes[x];
            item['data'].push(saldoMes.lucroPrejuizoMes);
          }
          this.serie.push(item);
        }
        console.log('serie' , this.serie);
        this.montaGrafico()
      })

  }

  montaGrafico() {
    this.chartOptions = {
      series: this.serie,
      chart: {
        type: "bar",
        height: 350
      },
      plotOptions: {
        bar: {
          horizontal: false,
          columnWidth: "55%"
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        show: true,
        width: 2,
        colors: ["transparent"]
      },
      xaxis: {
        categories: [
          "Feb",
          "Mar",
          "Apr",
          "May",
          "Jun",
          "Jul",
          "Aug",
          "Sep",
          "Oct"
        ]
      },
      yaxis: {
        title: {
          text: "$ (thousands)"
        }
      },
      fill: {
        opacity: 1
      },
      tooltip: {
        y: {
          formatter: function(val) {
            return "$ " + val + " thousands";
          }
        }
      }
    };
  }


  constructor(private srv:TipoAplicacaoApi) {
   
   
  }


}
