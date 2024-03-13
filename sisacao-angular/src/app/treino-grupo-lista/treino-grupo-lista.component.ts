import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { TreinoGrupoRede, TreinoGrupoRedeApi } from '../shared/sdk';

import { TreinoGrupoEditaComponent } from '../treino-grupo-edita/treino-grupo-edita.component';

@Component({
  selector: 'app-treino-grupo-lista',
  templateUrl: './treino-grupo-lista.component.html',
  styleUrls: ['./treino-grupo-lista.component.css']
})
export class TreinoGrupoListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TreinoGrupoRedeApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new TreinoGrupoRede();
  }

  getComponente() {
    return TreinoGrupoEditaComponent;
  }

  getFiltro() {
    return {
      'order' : 'grupoRedeId desc',
      'include' : [
        'grupoRede',
        'grupoAcao',
        'periodoTreinoRede',
        'grupoRegra'
      ]
    };
  }  
}
