import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { StartupFundoApi, StartupFundo } from '../shared/sdk';

@Component({
  selector: 'app-startup-fundo-edit',
  templateUrl: './startup-fundo-edit.component.html',
  styleUrls: ['./startup-fundo-edit.component.css']
})
export class StartupFundoEditComponent extends BaseEditComponent {


  constructor(protected dialogRef: MatDialogRef<StartupFundoEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: StartupFundoApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    return new StartupFundo();
  }
}
