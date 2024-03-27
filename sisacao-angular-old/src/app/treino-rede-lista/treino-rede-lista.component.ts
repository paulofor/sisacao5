import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { TreinoRedeApi, TreinoRede } from '../shared/sdk';
import { TreinoRedeEditaComponent } from '../treino-rede-edita/treino-rede-edita.component';

@Component({
  selector: 'app-treino-rede-lista',
  templateUrl: './treino-rede-lista.component.html',
  styleUrls: ['./treino-rede-lista.component.css']
})
export class TreinoRedeListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TreinoRedeApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new TreinoRede();
  }

  getComponente() {
    return TreinoRedeEditaComponent;
  }

  getFiltro() {
    return {
      'order' : 'redeNeuralId',
      'include' : ['redeNeural','grupoAcao','periodoTreinoRede','regraProjecao','tipoExemploTreino']
    };
  }  
}
