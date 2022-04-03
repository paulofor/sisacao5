import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Subscription, interval } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { PontoEntradaSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-ponto-entrada-simulacao-dia',
  templateUrl: './ponto-entrada-simulacao-dia.component.html',
  styleUrls: ['./ponto-entrada-simulacao-dia.component.css']
})
export class PontoEntradaSimulacaoDiaComponent extends BaseListComponent{

  private updateSubscription: Subscription;


  constructor(protected dialog: MatDialog, protected srv:PontoEntradaSimulacaoApi) { 
    super(dialog,srv)
  }



 
 
  carregaTela() {
    this.carregaLista();
    this.updateSubscription = interval(60000)
    .subscribe((val) => { 
      this.carregaLista()
    });
  }

  carregaLista() {
    this.srv.SituacaoAtual()
    .subscribe((result:any[]) => {
        console.log('SituacaoAtual: ' , result);
        this.listaBase = result;
    })
  }

 
}