import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TradeReal, TradeRealApi } from '../shared/sdk';

@Component({
  selector: 'app-trade-real-edita',
  templateUrl: './trade-real-edita.component.html',
  styleUrls: ['./trade-real-edita.component.css']
})
export class TradeRealEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TradeRealApi,
  ) {
    super(dialogRef,data,servico)
  }

  criaItem() {
    let item:TradeReal = new TradeReal();
    item.quantidade = 100;
    item.execucaoSimulacaoId = this.origem.id;
    item.ticker = this.origem.ticker;
    return item;
  }
  

 
  

}
