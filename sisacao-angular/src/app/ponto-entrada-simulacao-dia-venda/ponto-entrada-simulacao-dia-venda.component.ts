import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Subscription, interval } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { PontoEntradaSimulacaoApi, PontoEntradaSimulacao } from '../shared/sdk';
import { TradeNovoSimulacaoComponent } from '../trade-novo-simulacao/trade-novo-simulacao.component';

@Component({
  selector: 'app-ponto-entrada-simulacao-dia-venda',
  templateUrl: './ponto-entrada-simulacao-dia-venda.component.html',
  styleUrls: ['./ponto-entrada-simulacao-dia-venda.component.css']
})
export class PontoEntradaSimulacaoDiaVendaComponent  extends BaseListComponent{

  private updateSubscription: Subscription;


  constructor(protected dialog: MatDialog, protected srv:PontoEntradaSimulacaoApi) { 
    super(dialog,srv)
  }


  telaCompra(item:PontoEntradaSimulacao) {
    this.dialog.open(TradeNovoSimulacaoComponent, {
      width: '900px',
      data: {
          origem: item
      }
    });
  }
 
 
  carregaTela() {
    this.carregaLista();
    this.updateSubscription = interval(300000)
    .subscribe((val) => { 
      this.carregaLista()
    });
  }

  carregaLista() {
    //this.srv.SituacaoAtual("V")
    //.subscribe((result:any[]) => {
    //    console.log('SituacaoAtual: ' , result);
    //    his.listaBase = result;
    //})
  }

 
}