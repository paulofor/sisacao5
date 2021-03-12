import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { TradeApi } from '../shared/sdk';

@Component({
  selector: 'app-trade-execucao-simulacao',
  templateUrl: './trade-execucao-simulacao.component.html',
  styleUrls: ['./trade-execucao-simulacao.component.css']
})
export class TradeExecucaoSimulacaoComponent implements OnInit {

  constructor(protected dialogRef: MatDialogRef<TradeExecucaoSimulacaoComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TradeApi,
  ) {
  }

  ngOnInit() {
  }

}
