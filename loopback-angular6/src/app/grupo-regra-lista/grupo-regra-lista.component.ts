import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { EscolheRegraGrupoEditComponent } from '../escolhe-regra-grupo-edit/escolhe-regra-grupo-edit.component';
import { GrupoRegraEditaComponent } from '../grupo-regra-edita/grupo-regra-edita.component';
import { GrupoRegraApi, GrupoRegra } from '../shared/sdk';

@Component({
  selector: 'app-grupo-regra-lista',
  templateUrl: './grupo-regra-lista.component.html',
  styleUrls: ['./grupo-regra-lista.component.css']
})
export class GrupoRegraListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:GrupoRegraApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new GrupoRegra();
  }

  getComponente() {
    return GrupoRegraEditaComponent;
  }

  getFiltro() {
    return {
      'order' : 'quantidadeDia'
    }
  }

  getDialogo1() : any {
    return EscolheRegraGrupoEditComponent;
  }

}
