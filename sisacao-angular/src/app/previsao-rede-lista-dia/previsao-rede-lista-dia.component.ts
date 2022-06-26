import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RedeNeuralApi } from '../shared/sdk';

@Component({
  selector: 'app-previsao-rede-lista-dia',
  templateUrl: './previsao-rede-lista-dia.component.html',
  styleUrls: ['./previsao-rede-lista-dia.component.css']
})
export class PrevisaoRedeListaDiaComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:RedeNeuralApi,public router: Router) { 
    super(dialog,srv)
  }

 

  carregaTela() {
    this.srv.ListaPrevisaoDia()
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
        this.posCarregaLista();
    })
 }

  


}
