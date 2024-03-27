import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ParcelaEmprestimoApi } from '../shared/sdk';

@Component({
  selector: 'app-parcela-emprestimo-edit',
  templateUrl: './parcela-emprestimo-edit.component.html',
  styleUrls: ['./parcela-emprestimo-edit.component.css']
})
export class ParcelaEmprestimoEditComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ParcelaEmprestimoApi,
  ) {
    super(dialogRef,data,servico);
  }



 

}
