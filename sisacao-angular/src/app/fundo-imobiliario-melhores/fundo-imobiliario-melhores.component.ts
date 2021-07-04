import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { FundoImobiliarioApi } from '../shared/sdk';

@Component({
  selector: 'app-fundo-imobiliario-melhores',
  templateUrl: './fundo-imobiliario-melhores.component.html',
  styleUrls: ['./fundo-imobiliario-melhores.component.css']
})
export class FundoImobiliarioMelhoresComponent extends BaseListComponent  {

  constructor(protected dialog: MatDialog, protected srv:FundoImobiliarioApi) { 
    super(dialog,srv);
  }

  carregaTela() {
    this.srv.Melhores6M(25)
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
        this.posCarregaLista();
    })
}

}
