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

  listaBaseIndice: any[];


  constructor(protected dialog: MatDialog, protected srv:DiaPregaoApi) { 
    super(dialog,srv);
  }


  carregaTela() {
    this.srv.ExemploTreinoEntradaMaisRecente(90)
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
    })
    this.srv.ExemploTreinoEntradaMaisRecenteIndice(90)
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBaseIndice = result;
    })
}

}
