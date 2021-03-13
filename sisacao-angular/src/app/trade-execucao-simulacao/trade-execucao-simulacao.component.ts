import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { ExecucaoSimulacao, Trade, TradeApi } from '../shared/sdk';

@Component({
  selector: 'app-trade-execucao-simulacao',
  templateUrl: './trade-execucao-simulacao.component.html',
  styleUrls: ['./trade-execucao-simulacao.component.css']
})
export class TradeExecucaoSimulacaoComponent implements OnInit {

  listaTrade: Trade[];
  execucao: ExecucaoSimulacao;

  constructor(protected dialogRef: MatDialogRef<TradeExecucaoSimulacaoComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TradeApi
    ) {
  }

  ngOnInit() {
    if (this.data.item) {
      this.execucao = this.data.item;
      let filtro = { 'where': { 'execucaoSimulacaoId': this.execucao.id }, 'order': 'dataHoraEntrada' }
      console.log('Filtro:' , filtro);
      this.servico.find(filtro)
        .subscribe((result: Trade[]) => {
          this.listaTrade = result;
          console.log('ListaTrade:' , this.listaTrade);
        })
    } 
  }

 

}
