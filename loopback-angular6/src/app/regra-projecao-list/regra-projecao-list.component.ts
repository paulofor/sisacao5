import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RegraProjecaoEditComponent } from '../regra-projecao-edit/regra-projecao-edit.component';
import { RegraProjecao, RegraProjecaoApi } from '../shared/sdk';

@Component({
  selector: 'app-regra-projecao-list',
  templateUrl: './regra-projecao-list.component.html',
  styleUrls: ['./regra-projecao-list.component.css']
})
export class RegraProjecaoListComponent extends BaseListComponent {

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
      'order' : 'codigoRegraProjecao'
    }
  }

 

}
