import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { InstituicaoFinanceiraApi } from '../shared/sdk';
import { ValorMesSaldoEditComponent } from '../valor-mes-saldo-edit/valor-mes-saldo-edit.component';

@Component({
  selector: 'app-valor-mes-saldo-list',
  templateUrl: './valor-mes-saldo-list.component.html',
  styleUrls: ['./valor-mes-saldo-list.component.css']
})
export class ValorMesSaldoListComponent extends BaseListComponent {



  constructor(protected srv:InstituicaoFinanceiraApi, protected dialog: MatDialog) {
    super(dialog, srv);
  }

 
  getFiltro() {
    let filtro = {
      'order' : 'nome',
      'include' : { 'relation' : 'valorMesInstituicaoTipos' , 'scope' : { 'include' : 'tipoAplicacao'} }
    }
    return filtro;
  }


  

  getComponente() {
    return ValorMesSaldoEditComponent;
  }

  dataReferencia() : Number {
    var d = new Date();
    d.setMonth(d.getMonth() - 1);
    let mes = ("0" + (d.getMonth() + 1)).slice(-2);
    return Number(String(d.getFullYear()) + String(mes));
  }

}
