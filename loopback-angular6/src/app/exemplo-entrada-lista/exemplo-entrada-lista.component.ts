import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { DiaPregaoApi } from '../shared/sdk';

@Component({
  selector: 'app-exemplo-entrada-lista',
  templateUrl: './exemplo-entrada-lista.component.html',
  styleUrls: ['./exemplo-entrada-lista.component.css']
})
export class ExemploEntradaListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:DiaPregaoApi) { 
    super(dialog,srv);
  }


  carregaTela() {
    this.srv.ExemploTreinoEntradaMaisRecente(20)
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
    })
}

}
