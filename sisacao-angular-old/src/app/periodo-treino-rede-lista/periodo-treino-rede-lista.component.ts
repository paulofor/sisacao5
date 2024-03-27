import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { PeriodoTreinoRedeEditaComponent } from '../periodo-treino-rede-edita/periodo-treino-rede-edita.component';

import { PeriodoTreinoRede, PeriodoTreinoRedeApi } from '../shared/sdk';

@Component({
  selector: 'app-periodo-treino-rede-lista',
  templateUrl: './periodo-treino-rede-lista.component.html',
  styleUrls: ['./periodo-treino-rede-lista.component.css']
})
export class PeriodoTreinoRedeListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:PeriodoTreinoRedeApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new PeriodoTreinoRede();
  }

  getComponente() {
    return PeriodoTreinoRedeEditaComponent;
  }

  
  getFiltro() {
    return {
      'order' : 'diaNumFinalTreino desc'
    }
  } 
      
  

 

}
