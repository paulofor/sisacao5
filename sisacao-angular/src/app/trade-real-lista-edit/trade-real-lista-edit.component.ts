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

  mudouTarget(item) {
    console.log('Item Target:' , item.source.value);
    this.alteraTargetVenda(item.source.value);

  }
  alteraTargetVenda(percentual) {
    let valor = this.item.precoEntrada * (1- (percentual/100));
    this.item.precoTarget = valor.toFixed(2);
  }

  mudouStop(item) {
    console.log('Item Stop:' , item.source.value);
    this.alteraStopVenda(item.source.value);
  }
  alteraStopVenda(percentual) {
    let valor = this.item.precoEntrada * (1+ (percentual/100));
    this.item.precoStop = valor.toFixed(2);
    
  }

  calcularEntrada() {
    console.log('precoEntrada:' , this.item.precoEntrada);
    console.log('quantidade' , this.item.quantidade);
    this.item.custoEntrada = this.item.precoEntrada * this.item.quantidade;
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
