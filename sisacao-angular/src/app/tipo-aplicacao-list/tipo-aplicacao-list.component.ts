import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TipoAplicacaoApi } from '../shared/sdk';
import { TipoAplicacaoEditComponent } from '../tipo-aplicacao-edit/tipo-aplicacao-edit.component';

@Component({
  selector: 'app-tipo-aplicacao-list',
  templateUrl: './tipo-aplicacao-list.component.html',
  styleUrls: ['./tipo-aplicacao-list.component.css']
})
export class TipoAplicacaoListComponent extends BaseListComponent {

  constructor(protected srv:TipoAplicacaoApi, protected dialog: MatDialog) {
    super(dialog, srv);
  }

 
  getFiltro() {
    let filtro = {
      'order' : 'nome',
      'include' : 'instituicaoFinanceira'
    }
    return filtro;
  }


  

  getComponente() {
    return TipoAplicacaoEditComponent;
  }

}
