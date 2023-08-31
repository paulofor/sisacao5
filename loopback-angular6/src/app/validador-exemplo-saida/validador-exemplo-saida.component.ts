import { Component, OnInit } from '@angular/core';
import { CotacaoIntradayResultadoAcaoComponent } from '../cotacao-intraday-resultado-acao/cotacao-intraday-resultado-acao.component';
import { CotacaoDiarioAcao, CotacaoDiarioAcaoApi, CotacaoIntradayAcaoResultado, CotacaoIntradayAcaoResultadoApi, ExemploTreinoAcaoSaida, ExemploTreinoAcaoSaidaApi, RegraProjecao, RegraProjecaoApi } from '../shared/sdk';

@Component({
  selector: 'app-validador-exemplo-saida',
  templateUrl: './validador-exemplo-saida.component.html',
  styleUrls: ['./validador-exemplo-saida.component.css']
})
export class ValidadorExemploSaidaComponent implements OnInit {

  itemValidacao: ExemploTreinoAcaoSaida;
  cotacaoDiario: CotacaoDiarioAcao;
  cotacaoIntradayAnterior : CotacaoIntradayAcaoResultado[];
  regra:RegraProjecao;
  listaDiarioSaida: CotacaoDiarioAcao[];

  constructor(private srv:ExemploTreinoAcaoSaidaApi, private srvDiario:CotacaoDiarioAcaoApi, 
          private srvIntra: CotacaoIntradayAcaoResultadoApi, private srvRegra:RegraProjecaoApi) { }

  ngOnInit() {
    this.carregaTela();
  }

  carregaTela() {
    this.itemValidacao = null;
    this.cotacaoDiario = null;
    this.cotacaoIntradayAnterior = null;
    this.regra = null;
    this.listaDiarioSaida = null;
    this.srv.ItemValidacao()
      .subscribe((result:ExemploTreinoAcaoSaida) => {
        console.log('item validacao:' , result);
        this.itemValidacao = result;
        this.srvRegra.findById(this.itemValidacao.regraProjecaoId)
          .subscribe((result:RegraProjecao) => {
            console.log('regra:' , result);
            this.regra = result;
            if (this.itemValidacao.diaNumSaida) {
              if (this.regra.tipoCompraVenda=="V") {
                this.itemValidacao['saidaTarget'] = this.itemValidacao.valorEntrada * (1-this.regra.target);
                this.itemValidacao['saidaStop'] = this.itemValidacao.valorEntrada * (1+this.regra.stop);
              }
              if (this.regra.tipoCompraVenda=="C") {
                this.itemValidacao['saidaTarget'] = this.itemValidacao.valorEntrada * (1+this.regra.target);
                this.itemValidacao['saidaStop'] = this.itemValidacao.valorEntrada * (1-this.regra.stop);
              }

              this.carregaDiarioSaida();
            }
          })
        this.carregaDiario();
        this.carregaCotacaoAnterior();
        
      })
  }

  carregaDiarioSaida() {
    this.srvDiario.ListaValidacaoRegraProjecao(this.itemValidacao.ticker,this.itemValidacao.diaNumPrevisao,this.regra.diaLimite)
      .subscribe((result:CotacaoDiarioAcao[]) => {
        this.listaDiarioSaida = result;
      })
  }

  validar() {
    this.srv.ValidaExemploSaida(1,this.itemValidacao.ticker,this.itemValidacao.diaNumPrevisao,this.itemValidacao.regraProjecaoId)
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  classeEntrada() {
    if ((this.itemValidacao.valorEntrada > this.cotacaoDiario.minimo) && ((this.itemValidacao.valorEntrada < this.cotacaoDiario.maximo))) {
      return 'dgc-verde'
    } else {
      return 'dgc-vermelho'
    }
  }

  classeSaida(item,valor) {
    if ((valor > item.minimo) && (valor < item.maximo)) {
      return 'dgc-verde'
    } else {
      return 'dgc-vermelho'
    }
  }

  precoEntradaVenda() {
    let valor = this.cotacaoIntradayAnterior[0].valor * (1+this.regra.percentualEntradaDataset)
    return valor;
  }
  precoEntradaCompra() {
    let valor = this.cotacaoIntradayAnterior[0].valor * (1-this.regra.percentualEntradaDataset)
    return valor;
  }

  lucroPrejuizo() {
    let resultado: number;
    if (this.regra.tipoCompraVenda=="V") {
      resultado = ((this.itemValidacao.valorEntrada - this.itemValidacao.valorSaida) / this.itemValidacao.valorEntrada) * 100;
    }
    if (this.regra.tipoCompraVenda=="C") {
      resultado = ((this.itemValidacao.valorSaida - this.itemValidacao.valorEntrada) / this.itemValidacao.valorEntrada) * 100;
    }
    return resultado;
  }


  carregaDiario() {
    let filtro = { 'where' : {'and' : [
          {'ticker' : this.itemValidacao.ticker}, 
          {'diaNum' : this.itemValidacao.diaNumPrevisao} 
        ]}}
    this.srvDiario.findOne(filtro)
        .subscribe((result:CotacaoDiarioAcao) => {
          console.log('diario:' , result);
          this.cotacaoDiario = result;
        })
  }

  carregaCotacaoAnterior() {
    this.srvIntra.ObtemCotacaoDiaAnterior(this.itemValidacao.ticker, this.itemValidacao.diaNumPrevisao)
      .subscribe((result:CotacaoIntradayAcaoResultado[]) => {
        console.log('intraday:' , result);
        this.cotacaoIntradayAnterior = result;
      })
  }

}
