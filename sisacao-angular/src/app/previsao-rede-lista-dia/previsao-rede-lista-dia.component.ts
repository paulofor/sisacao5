import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RedeNeuralApi, TreinoRedeApi } from '../shared/sdk';

@Component({
  selector: 'app-previsao-rede-lista-dia',
  templateUrl: './previsao-rede-lista-dia.component.html',
  styleUrls: ['./previsao-rede-lista-dia.component.css']
})
export class PrevisaoRedeListaDiaComponent  extends BaseListComponent {

  

  constructor(protected dialog: MatDialog, public srvTreino: TreinoRedeApi, public router: Router) { 
    super(dialog,srvTreino)
  }

  carregaTela() {
    this.srvTreino.ListaPrevisaoDiaTreino()
        .subscribe((result:any[]) => {
            console.log('listaBase: ' , result);
            this.listaBase = result;
            this.posCarregaLista();
        })
  }
 
  /*
  carregaTela() {
    this.srv.ListaPrevisaoDia()
    .subscribe((result:any[]) => {
        console.log('rede: ' , result);
        this.listaBase = result;
        this.srvTreino.ListaPrevisaoDiaTreino()
        .subscribe((result:any[]) => {
            console.log('treino: ' , result);
            this.listaBase = this.listaBase.concat(result);
            this.posCarregaLista();
            console.log('listaBase: ' , this.listaBase);
        })
        
    });
  }
  */
  


  


}
