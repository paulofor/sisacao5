import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TradeRealApi } from '../shared/sdk';

@Component({
  selector: 'app-trade-real-lista-edit',
  templateUrl: './trade-real-lista-edit.component.html',
  styleUrls: ['./trade-real-lista-edit.component.css']
})
export class TradeRealListaEditComponent extends BaseEditComponent {


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TradeRealApi
  ) {
    super(dialogRef,data,servico);
  }
}
