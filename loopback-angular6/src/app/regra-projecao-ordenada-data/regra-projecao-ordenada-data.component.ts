import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RegraProjecaoEditComponent } from '../regra-projecao-edit/regra-projecao-edit.component';
import { RegraProjecaoApi, RegraProjecao } from '../shared/sdk';

@Component({
  selector: 'app-regra-projecao-ordenada-data',
  templateUrl: './regra-projecao-ordenada-data.component.html',
  styleUrls: ['./regra-projecao-ordenada-data.component.css']
})
export class RegraProjecaoOrdenadaDataComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:RegraProjecaoApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new RegraProjecao();
  }

  getComponente() {
    return RegraProjecaoEditComponent;
  }

  getFiltro() {
    return {
      'order' : 'dataHoraAcesso desc',
      'limit' : 20,
      'include' : {'relation' : 'regraProjecaoHists' , 'scope' : {
        'limit' : 3,
        'order' : 'dataHoraAtual desc'
      }}
    }
  }

 

}
