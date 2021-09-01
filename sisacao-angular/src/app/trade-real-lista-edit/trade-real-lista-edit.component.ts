import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TradeReal, TradeRealApi } from '../shared/sdk';

@Component({
  selector: 'app-trade-real-lista-edit',
  templateUrl: './trade-real-lista-edit.component.html',
  styleUrls: ['./trade-real-lista-edit.component.css']
})
export class TradeRealListaEditComponent extends BaseEditComponent {

  precoCompraExec: number;
  precoStopExec: number;
  precoTargetExec: number;

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TradeRealApi
  ) {
    super(dialogRef,data,servico);
  }

  preSubmit() {

  }

  posItem() {
    let itemTrade:TradeReal = this.item;
    if (itemTrade.tipo=='C') {
      this.precoCompraExec = itemTrade.execucaoSimulacao.precoEntrada;
      this.precoStopExec = itemTrade.execucaoSimulacao.precoEntrada * (1-itemTrade.execucaoSimulacao.stop);
      this.precoTargetExec = itemTrade.execucaoSimulacao.precoEntrada * (1+itemTrade.execucaoSimulacao.target);
    }
    if (itemTrade.tipo=='V') {
      this.precoCompraExec = itemTrade.execucaoSimulacao.precoEntrada;
      this.precoStopExec = itemTrade.execucaoSimulacao.precoEntrada * (1+itemTrade.execucaoSimulacao.stop);
      this.precoTargetExec = itemTrade.execucaoSimulacao.precoEntrada * (1-itemTrade.execucaoSimulacao.target);
    }
    
    //console.log('precoCompraExec:' , itemTrade.execucaoSimulacao.precoEntrada);
  }
}
