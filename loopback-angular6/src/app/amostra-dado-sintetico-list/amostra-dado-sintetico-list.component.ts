import { Component, OnInit } from '@angular/core';
import { AmostraDadoSintetico, AmostraDadoSinteticoApi, TipoExemploTreinoApi } from '../shared/sdk';
import { AmostraDadoSinteticoEditComponent } from '../amostra-dado-sintetico-edit/amostra-dado-sintetico-edit.component';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';

@Component({
  selector: 'app-amostra-dado-sintetico-list',
  templateUrl: './amostra-dado-sintetico-list.component.html',
  styleUrls: ['./amostra-dado-sintetico-list.component.css']
})
export class AmostraDadoSinteticoListComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:AmostraDadoSinteticoApi,public router: Router, 
      private srvTipoExemplo:TipoExemploTreinoApi ) { 
    super(dialog,srv)
  }

  criaItem() {
    return new AmostraDadoSintetico();
  }

  getComponente() {
    return AmostraDadoSinteticoEditComponent;
  }


  getFiltro() {
    return {}
  }
   
  carregaTela() {
    const filtro = {
      'order' : 'qtdeDias',
      'include' : 'amostraDadoSinteticos'
    }
    this.srvTipoExemplo.find(filtro)
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
        this.posCarregaLista();
    })
}

 

}
