import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { StartupEmpresa, StartupEmpresaApi } from '../shared/sdk';

@Component({
  selector: 'app-startup-empresa-edit',
  templateUrl: './startup-empresa-edit.component.html',
  styleUrls: ['./startup-empresa-edit.component.css']
})
export class StartupEmpresaEditComponent extends BaseEditComponent  {

  constructor(protected dialogRef: MatDialogRef<StartupEmpresaEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: StartupEmpresaApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    return new StartupEmpresa();
  }

}
