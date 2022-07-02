import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TradeRealApi, TradeReal, PrevisaoRede } from '../shared/sdk';

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
    console.log('origem:' , this.origem);
    if (this.origem.valorPrevisao) {
      console.log('Previsao');
      item.previsaoRedeId = this.origem.id;
      item.tipo = this.origem.tipoCompraVenda;
    } else {
      item.execucaoSimulacaoId = this.origem.execucaoSimulacaoId;
      item.tipo = this.origem.tipo;
    }
    item.execucaoSimulacaoId = this.origem.execucaoSimulacaoId;
    item.ticker = this.origem.ticker;
    return item;
  }
  

 
  

}