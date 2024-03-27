import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { EmprestimoP2PApi, EmprestimoP2P } from '../shared/sdk';

@Component({
  selector: 'app-emprestimo-p2-pedita',
  templateUrl: './emprestimo-p2-pedita.component.html',
  styleUrls: ['./emprestimo-p2-pedita.component.css']
})
export class EmprestimoP2PEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: EmprestimoP2PApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let novo = new EmprestimoP2P();
    novo.ativo = 1;
    return novo;
  }

 

}
