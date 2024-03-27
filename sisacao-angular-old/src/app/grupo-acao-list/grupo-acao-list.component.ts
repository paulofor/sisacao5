import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { EscolheAcaoGrupoEditComponent } from '../escolhe-acao-grupo-edit/escolhe-acao-grupo-edit.component';
import { ExperimentoSimulacaoEditComponent } from '../experimento-simulacao-edit/experimento-simulacao-edit.component';
import { GrupoAcaoEditComponent } from '../grupo-acao-edit/grupo-acao-edit.component';
import { GrupoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-grupo-acao-list',
  templateUrl: './grupo-acao-list.component.html',
  styleUrls: ['./grupo-acao-list.component.css']
})
export class GrupoAcaoListComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:GrupoAcaoApi) { 
    super(dialog,srv);
  }


  getComponente() {
    return GrupoAcaoEditComponent;
  }

  getFiltro() {
    return {
       
    }
  }

  getDialogo1() : any {
    return EscolheAcaoGrupoEditComponent;
  }

}
