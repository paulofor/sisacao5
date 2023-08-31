import { Component, OnInit } from '@angular/core';
import { TreinoRede, TreinoRedeApi } from '../shared/sdk';

@Component({
  selector: 'app-ranking-treino-rede',
  templateUrl: './ranking-treino-rede.component.html',
  styleUrls: ['./ranking-treino-rede.component.css']
})
export class RankingTreinoRedeComponent implements OnInit {

  listaTreinoCompra : TreinoRede[];
  listaTreinoVenda : TreinoRede[];

  constructor(private srv:TreinoRedeApi) { 

  }

  ngOnInit() {
    this.carregaTelaVenda();
    this.carregaTelaCompra();
    
  }

  classeAtivo(item) {
    if (item.ativoPrevisao==1) return "dgc-treino-previsao"
    else return "";
  }

  carregaTelaVenda() {
    let filtroVenda = {
      'where' : {'tipoCompraVenda' : 'V'},
      'order' : 'pontuacaoTeste desc',
      'limit' : 15,
      'include' : ['regraProjecao','redeNeural' , 'periodoTreinoRede']
    }
    this.srv.find(filtroVenda)
      .subscribe((result:TreinoRede[]) => {
        console.log('resultVenda:' , result);
        this.listaTreinoVenda = result;
      })
  } 

  carregaTelaCompra() {
    let filtroCompra = {
      'where' : {'tipoCompraVenda' : 'C'},
      'order' : 'pontuacaoTeste desc',
      'limit' : 15,
      'include' : ['regraProjecao','redeNeural', 'periodoTreinoRede']
    }
    this.srv.find(filtroCompra)
      .subscribe((result:TreinoRede[]) => {
        console.log('resultCompra:' , result);
        this.listaTreinoCompra = result;
      })
  } 

}
