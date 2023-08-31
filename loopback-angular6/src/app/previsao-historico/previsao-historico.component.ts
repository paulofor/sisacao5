import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { PrevisaoRedeApi } from '../shared/sdk';

@Component({
  selector: 'app-previsao-historico',
  templateUrl: './previsao-historico.component.html',
  styleUrls: ['./previsao-historico.component.css']
})
export class PrevisaoHistoricoComponent extends BaseListComponent {

  

  constructor(protected dialog: MatDialog, public srv: PrevisaoRedeApi, public router: Router) { 
    super(dialog,srv)
  }

  carregaTela() {
    this.srv.PrevisaoHistorico(20)
        .subscribe((result:any[]) => {
            console.log('listaBase: ' , result);
            this.listaBase = result;
            this.posCarregaLista();
        })
  }
 
  limpaDia(item) {
    this.srv.LimpaDiaTreino(item.diaNum)
      .subscribe((result) => {
        this.carregaTela();
      })
  }


}