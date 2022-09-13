import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { interval, Subscription } from 'rxjs';
import { BaseListComponent } from '../base-component/base-list-component';
import { TradeRealApi } from '../shared/sdk';
import { TargetStopEditaComponent } from '../target-stop-edita/target-stop-edita.component';

@Component({
  selector: 'app-trade-ativo',
  templateUrl: './trade-ativo.component.html',
  styleUrls: ['./trade-ativo.component.css']
})
export class TradeAtivoComponent extends BaseListComponent {

  totalPrejuizo : number;
  resumo: any;
  private updateSubscription: Subscription;

  constructor(protected dialog: MatDialog, protected srv:TradeRealApi,public router: Router) { 
    super(dialog,srv)
    this.updateSubscription = interval(300000)
    .subscribe((val) => { 
      this.carregaTela()
    });
  }


  carregaTela() {
    this.srv.ListaAbertoComPreco()
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
        this.posCarregaLista();
        this.srv.ResumoAtual()
          .subscribe((result) => {
            console.log('Resumo: ' , result);
            this.resumo = result;
          })
    })
  }

  posCarregaLista() {
    
    this.totalPrejuizo = 0;
    this.listaBase.forEach((item) => {
      item.prejuizoTotal = (item.precoEntrada - item.precoStop) * item.quantidade;
      this.totalPrejuizo += item.prejuizoTotal;
      item.diferencaStop = ((item.precoStop - item.precoAtual) / item.precoAtual) * 100;
      item.diferencaTarget = ((item.precoTarget - item.precoAtual) / item.precoAtual) * 100;
      item.percentualStop = ((item.precoStop - item.precoEntrada) / item.precoEntrada) * 100;
      item.percentualTarget = ((item.precoTarget - item.precoEntrada) / item.precoEntrada) * 100;
    })
  }
  /*
  getFiltro() {
    return {
      'where' : {'dataSaida' : {'eq' : null}}
    }
  }
  */
 
  getComponente() {
    return TargetStopEditaComponent;
  }
  

 }