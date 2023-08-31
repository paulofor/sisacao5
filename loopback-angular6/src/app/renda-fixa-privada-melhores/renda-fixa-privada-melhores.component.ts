import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { RendaFixaPrivadaApi } from '../shared/sdk';

@Component({
  selector: 'app-renda-fixa-privada-melhores',
  templateUrl: './renda-fixa-privada-melhores.component.html',
  styleUrls: ['./renda-fixa-privada-melhores.component.css']
})
export class RendaFixaPrivadaMelhoresComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv: RendaFixaPrivadaApi) {
    super(dialog, srv);
  }

  carregaTela() {
    this.srv.ListaMelhoresDia(30)
      .subscribe((result: any[]) => {
        console.log('result: ', result);
        this.listaBase = result;
        this.posCarregaLista();
      })


  }

  

}
