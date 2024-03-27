import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TipoAplicacaoSaldoMesApi } from '../shared/sdk';

@Component({
  selector: 'app-plano-mensal-edita',
  templateUrl: './plano-mensal-edita.component.html',
  styleUrls: ['./plano-mensal-edita.component.css']
})
export class PlanoMensalEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TipoAplicacaoSaldoMesApi,
  ) {
    super(dialogRef,data,servico);
  }

  

 

}
