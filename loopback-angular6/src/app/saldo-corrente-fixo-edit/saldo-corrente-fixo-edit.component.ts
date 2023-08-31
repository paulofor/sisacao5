import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TipoAplicacaoSaldoMesApi } from '../shared/sdk';

@Component({
  selector: 'app-saldo-corrente-fixo-edit',
  templateUrl: './saldo-corrente-fixo-edit.component.html',
  styleUrls: ['./saldo-corrente-fixo-edit.component.css']
})
export class SaldoCorrenteFixoEditComponent  extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TipoAplicacaoSaldoMesApi,
  ) {
    super(dialogRef,data,servico);
  }

 

 

}
