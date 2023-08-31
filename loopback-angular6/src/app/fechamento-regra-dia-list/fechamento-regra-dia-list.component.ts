import { Component, OnInit } from '@angular/core';
import { FechamentoRegraDia, FechamentoRegraDiaApi } from '../shared/sdk';
import { FechamentoRegraDiaEditComponent } from '../fechamento-regra-dia-edit/fechamento-regra-dia-edit.component';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';

@Component({
  selector: 'app-fechamento-regra-dia-list',
  templateUrl: './fechamento-regra-dia-list.component.html',
  styleUrls: ['./fechamento-regra-dia-list.component.css']
})
export class FechamentoRegraDiaListComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:FechamentoRegraDiaApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new FechamentoRegraDia();
  }

  getComponente() {
    return FechamentoRegraDiaEditComponent;
  }


  getFiltro() {
    return {
      'include' : 'grupoAcao'
    }
  }
   

 

}
