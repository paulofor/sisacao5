import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { ParametroRegraEditComponent } from '../parametro-regra-edit/parametro-regra-edit.component';
import { RegraSimulacaoEditComponent } from '../regra-simulacao-edit/regra-simulacao-edit.component';
import { RegraSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-regra-simulacao-list',
  templateUrl: './regra-simulacao-list.component.html',
  styleUrls: ['./regra-simulacao-list.component.css']
})
export class RegraSimulacaoListComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:RegraSimulacaoApi) {
    super(dialog,srv)
  }

  getComponente() {
    return RegraSimulacaoEditComponent;
  }

  getDialogo1() {
    return ParametroRegraEditComponent
  }


  getFiltro() {
    let filtro = { 'include' : 'parametroRegras' };
    return filtro;
  }

}
