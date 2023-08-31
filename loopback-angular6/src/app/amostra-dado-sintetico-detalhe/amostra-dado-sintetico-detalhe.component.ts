import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseItemIdComponent } from '../base-component/base-item-id-component';
import { AmostraDadoSinteticoApi, ExemploDadoSinteticoApi } from '../shared/sdk';

@Component({
  selector: 'app-amostra-dado-sintetico-detalhe',
  templateUrl: './amostra-dado-sintetico-detalhe.component.html',
  styleUrls: ['./amostra-dado-sintetico-detalhe.component.css']
})
export class AmostraDadoSinteticoDetalheComponent extends BaseItemIdComponent {

  constructor(protected dialog: MatDialog, protected srv: AmostraDadoSinteticoApi, protected router: ActivatedRoute, 
      protected srvExemplo: ExemploDadoSinteticoApi) {
    super(dialog, srv, router);
  }

  recalcular() {
    this.srvExemplo.GerarPorAmostra(this.principal.id)
    .subscribe(result => {
      setTimeout(() => {
        this.carregaTela();
      }, 5000); 
    });
  
  }


  getFiltro() {
    return {
      'include' : { 'relation': 'exemploDadoSinteticos' , 'scope' : {'limit' : 15 }},
    }
  }


}
