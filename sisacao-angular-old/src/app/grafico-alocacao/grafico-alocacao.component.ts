
import { Component, ViewChild } from "@angular/core";
import { ChartComponent } from "ng-apexcharts";

import {
  ApexNonAxisChartSeries,
  ApexResponsive,
  ApexChart
} from "ng-apexcharts";
import { ValorMesInstituicaoTipoApi } from "../shared/sdk";

export type ChartOptions = {
  series: ApexNonAxisChartSeries;
  chart: ApexChart;
  responsive: ApexResponsive[];
  labels: any;
};

@Component({
  selector: 'app-grafico-alocacao',
  templateUrl: './grafico-alocacao.component.html',
  styleUrls: ['./grafico-alocacao.component.css']
})
export class GraficoAlocacaoComponent {
  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  totais: any[];
  valores: number[];
  rotulos: string[];

  inicializa() {
    this.srv.TotaisMesCorrente()
      .subscribe((result:any[]) => {
        this.totais = result;
        console.log('Totais:' , this.totais);
        this.valores = new Array(this.totais.length);
        this.rotulos = new Array(this.totais.length);
        for (let i=0; i<this.totais.length; i++) {
          this.valores[i] = this.totais[i]['valorTotal'];
          this.rotulos[i] = this.totais[i]['nome'] + ' (' + this.totais[i]['valorTotal'] + ')';
        }
        this.montaGrafico();
      }) 
  }

  montaGrafico() {
    this.chartOptions = {
      //series: [44, 55, 13, 43, 22],
      series : this.valores,
      chart: {
        width: 480,
        type: "pie"
      },
      //labels: ["Team A", "Team B", "Team C", "Team D", "Team E"],
      labels: this.rotulos,
      responsive: [
        {
          breakpoint: 480,
          options: {
            chart: {
              width: 200,
            },
            legend: {
              position: "bottom"
            }
          }
        }
      ]
    };
  }


  constructor(private srv:ValorMesInstituicaoTipoApi) {
    this.inicializa();
    
  }
}

