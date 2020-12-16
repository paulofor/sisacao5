import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material';
import { AtributoDataSetEditComponent } from '../atributo-data-set-edit/atributo-data-set-edit.component';
import { BaseListComponent } from '../base-component/base-list-component';
import { StartupEmpresa, StartupEmpresaApi } from '../shared/sdk';
import { StartupEmpresaEditComponent } from '../startup-empresa-edit/startup-empresa-edit.component';
import { StartupInvestimentoEditComponent } from '../startup-investimento-edit/startup-investimento-edit.component';

@Component({
  selector: 'app-startup-empresa-list',
  templateUrl: './startup-empresa-list.component.html',
  styleUrls: ['./startup-empresa-list.component.css']
})
export class StartupEmpresaListComponent extends BaseListComponent  {

 

  constructor(protected srv:StartupEmpresaApi, protected dialog: MatDialog) {
    super(dialog, srv);
  }

 
  getFiltro() {
    let filtro = {'include' : 
    { 'relation' : 'startupInvestimentos' , 'scope' : {'include' : 'startupFundo'}},
    'order' : 'id desc'
    };
    return filtro;
  }

  getDialogo1() {
    return StartupInvestimentoEditComponent;
  }

  getComponente() {
    return StartupEmpresaEditComponent;
  }
  
}
