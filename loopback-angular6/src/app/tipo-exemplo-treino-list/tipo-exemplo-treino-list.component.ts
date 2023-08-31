import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TipoExemploTreinoApi } from '../shared/sdk';
import { TipoExemploTreinoEditComponent } from '../tipo-exemplo-treino-edit/tipo-exemplo-treino-edit.component';

@Component({
  selector: 'app-tipo-exemplo-treino-list',
  templateUrl: './tipo-exemplo-treino-list.component.html',
  styleUrls: ['./tipo-exemplo-treino-list.component.css']
})
export class TipoExemploTreinoListComponent extends BaseListComponent {


 

  constructor(protected srv:TipoExemploTreinoApi, protected dialog: MatDialog) {
    super(dialog, srv);
  }

  getComponente() {
    return TipoExemploTreinoEditComponent;
  }
  
  getFiltro() {
    return {}
  }

  atualiza() {
    this.srv.AtualizaDatas()
      .subscribe((result) => {
        this.carregaTela();
      })
  }

}
