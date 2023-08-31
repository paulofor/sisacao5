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
  selector: 'app-item-trade-real-visual',
  templateUrl: './item-trade-real-visual.component.html',
  styleUrls: ['./item-trade-real-visual.component.css']
})
export class ItemTradeRealVisualComponent implements OnInit {

  private updateSubscription: Subscription;

  @Input() trade: any;
  listaCotacao: CotacaoIntradayAcao[];
  @ViewChild("chart") chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  dados: any[];
  rotulos: any[];
  target: any[];
  stop: any[];

  entradas: any[];
  dados_entrada1: any[];
  dados_entrada2: any[];

  constructor(private srvCotacao:CotacaoIntradayAcaoApi, private srvExecucaoSimulacao : ExecucaoSimulacaoApi) { }

  DIAS = 5;


  ngOnInit() {
    //this.carregaEntrada();
    this.carregaPrecoAtual();
    this.updateSubscription = interval(300000)
    .subscribe((val) => { 
      this.carregaPrecoAtual()
    });
  }

  getPercentualTargetTrade() {
    return ((this.trade.precoTarget - this.trade.precoEntrada) / this.trade.precoEntrada) * 100;
  }
  getPercentualStopTrade() {
    return ((this.trade.precoStop - this.trade.precoEntrada) / this.trade.precoEntrada) * 100;
  }

  getPercentualTarget() {
    let valor = this.listaCotacao[0].valor;
    return ((this.trade.precoTarget - valor) / valor) * 100;
  }
  getPercentualStop() {
    let valor = this.listaCotacao[0].valor;
    return ((this.trade.precoStop - valor) / valor) * 100;
  }

  getDataHoraUlt() {
    
    let valor:string = this.listaCotacao[0].dataHora.toString();
    //console.log('DataHora' + valor);
    return "(" + valor.substring(11,16) + ")";
  }
  
  verificaMarcaTexto(valorPerc,valor):string {
    let perc =  ((valorPerc - valor) / valor) * 100;
    if (perc<=PERCENTUAL_AVISO && perc>=(PERCENTUAL_AVISO*-1)) {
      return "dgc-marcatexto"
    } else {
      return "";
    }
  }

  carregaEntrada() {
    this.srvExecucaoSimulacao.ObtemMelhoresPontoEntradaPorTikcer(this.trade.ticker,3,this.trade.tipo)
      .subscribe((result:any[]) => {
        console.log('Entradas' , result);
        this.entradas = result;
        this.carregaPrecoAtual()
      })
  }

  classeSaldo() {
    if ((this.getSaldo()) > 0) return 'dgc-lucro';
    if ((this.getSaldo()) < 0) return 'dgc-prejuizo';
    return '';
  }

  getPercentual() {
    let valorAtual = this.listaCotacao[0].valor;
    var percentual = (100* (valorAtual - this.trade.precoEntrada) / this.trade.precoEntrada);
    if (this.trade.tipo && this.trade.tipo=='V') percentual = -1* percentual;
    return percentual.toFixed(1);
  }
  getSaldo() {
    let valorAtual = this.listaCotacao[0].valor;
    var saldo = (valorAtual-this.trade.precoEntrada) * this.trade.quantidade;
    if (this.trade.tipo && this.trade.tipo=='V') saldo = -1* saldo;
    return saldo;
  }

  carregaPrecoAtual() {
    let pontos = 32 * this.DIAS;
    this.srvCotacao.AtualPorTicker(this.trade.ticker,pontos)
      .subscribe((result:CotacaoIntradayAcao[]) => {
        this.listaCotacao = result;
        //console.log('entrada-cotacao' , this.entradas);
        //console.log('cotacao:' , this.listaCotacao);
        this.dados = new Array();
        this.rotulos = new Array();
        //this.dados_entrada1 = new Array();
        //this.dados_entrada2 = new Array();
        for (let x=this.listaCotacao.length-1;x>=0;x--) {
          this.dados.push(this.listaCotacao[x].valor);
          //this.rotulos.push(this.listaCotacao[x].dataHora);
          this.rotulos.push(x);
          //this.dados_entrada1.push(this.entradas[0].precoEntrada);
          //this.dados_entrada2.push(this.entradas[1].precoEntrada);
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
        categories: this.rotulos
      }
    };
  }

}







