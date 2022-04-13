import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TradeRealApi, TradeReal } from '../shared/sdk';

@Component({
  selector: 'app-trade-novo-simulacao',
  templateUrl: './trade-novo-simulacao.component.html',
  styleUrls: ['./trade-novo-simulacao.component.css']
})
export class TradeNovoSimulacaoComponent  extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TradeRealApi,
  ) {
    super(dialogRef,data,servico)
  }

  criaItem() {
    let item:TradeReal = new TradeReal();
    item.execucaoSimulacaoId = this.origem.execucaoSimulacaoId;
    item.ticker = this.origem.ticker;
    item.tipo = this.origem.tipo;
    return item;
  }
  

 
  

}