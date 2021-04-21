import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TradeReal, TradeRealApi } from '../shared/sdk';
import { TradeRealListaEditComponent } from '../trade-real-lista-edit/trade-real-lista-edit.component';

@Component({
  selector: 'app-trade-real-lista',
  templateUrl: './trade-real-lista.component.html',
  styleUrls: ['./trade-real-lista.component.css']
})
export class TradeRealListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TradeRealApi) { 
    super(dialog,srv);
  }

  getComponente() {
    return TradeRealListaEditComponent;
  }
 
  calcular(item:TradeReal) {
   if (item.posicaoAtual==0) {
     this.srv.CalculaSaida(item.id)
      .subscribe((result) => {
        this.carregaTela();
      })
   }
   if (item.posicaoAtual==1) {
    this.srv.CalculaEstimativa(item.id)
     .subscribe((result) => {
       this.carregaTela();
     })
  }
  }


  getFiltro() {
    return {
      'order' : 'dataEntrada desc',
      'include' : [
          {'relation' : 'execucaoSimulacao'},
          {'relation' : 'ativoAcao' }
      ]
    }
  }
}
