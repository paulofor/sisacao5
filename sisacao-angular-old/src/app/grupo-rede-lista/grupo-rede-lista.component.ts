import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { EscolheRedeGrupoEditComponent } from '../escolhe-rede-grupo-edit/escolhe-rede-grupo-edit.component';
import { GrupoRedeEditaComponent } from '../grupo-rede-edita/grupo-rede-edita.component';
import { GrupoRedeApi, GrupoRegra } from '../shared/sdk';

@Component({
  selector: 'app-grupo-rede-lista',
  templateUrl: './grupo-rede-lista.component.html',
  styleUrls: ['./grupo-rede-lista.component.css']
})
export class GrupoRedeListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:GrupoRedeApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new GrupoRegra();
  }

  getComponente() {
    return GrupoRedeEditaComponent;
  }

  getFiltro() {
    return {
      'order' : 'id'
    }
  }

  getDialogo1() : any {
    return EscolheRedeGrupoEditComponent;
  }

}
