import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

import { RegraProjecao, RegraProjecaoApi } from '../shared/sdk';

@Component({
  selector: 'app-regra-projecao-edit',
  templateUrl: './regra-projecao-edit.component.html',
  styleUrls: ['./regra-projecao-edit.component.css']
})
export class RegraProjecaoEditComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RegraProjecaoApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let novo = new RegraProjecao();
    return novo;
  }

 

}
