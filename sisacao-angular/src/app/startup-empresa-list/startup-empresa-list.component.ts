import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { StartupEmpresa, StartupEmpresaApi } from '../shared/sdk';
import { StartupEmpresaEditComponent } from '../startup-empresa-edit/startup-empresa-edit.component';

@Component({
  selector: 'app-startup-empresa-list',
  templateUrl: './startup-empresa-list.component.html',
  styleUrls: ['./startup-empresa-list.component.css']
})
export class StartupEmpresaListComponent extends BaseListComponent  {

 

  constructor(protected srv:StartupEmpresaApi, protected dialog: MatDialog) {
    super(dialog, srv);
  }

 

  getComponente() {
    return StartupEmpresaEditComponent;
  }
  
}
