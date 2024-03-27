import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ParametroRegra, ParametroRegraApi } from '../shared/sdk';

@Component({
  selector: 'app-parametro-regra-edit',
  templateUrl: './parametro-regra-edit.component.html',
  styleUrls: ['./parametro-regra-edit.component.css']
})
export class ParametroRegraEditComponent  extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ParametroRegraApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    let parametro:ParametroRegra = new ParametroRegra();
    parametro.regraSimulacaoId = this.origem.id;
    return parametro;
  }
}
