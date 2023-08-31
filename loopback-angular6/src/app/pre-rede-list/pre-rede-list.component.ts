import { Component, OnInit } from '@angular/core';
import { PreRedeNeural, PreRedeNeuralApi } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { PreRedeEditComponent } from '../pre-rede-edit/pre-rede-edit.component';


@Component({
  selector: 'app-pre-rede-list',
  templateUrl: './pre-rede-list.component.html',
  styleUrls: ['./pre-rede-list.component.css']
})
export class PreRedeListComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:PreRedeNeuralApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new PreRedeNeural();
  }

  getComponente() {
    return PreRedeEditComponent;
  }


  getFiltro() {
    return {
      'include' : ['tipoExemploTreino1','tipoExemploTreino2','periodoTreinoRede','grupoAcao',
        'regraProjecaoVenda1','regraProjecaoVenda2','regraProjecaoVenda3', 
        'regraProjecaoCompra1','regraProjecaoCompra2', 'regraProjecaoCompra3'
      ]
    }
  }
 
  
  

 

}
