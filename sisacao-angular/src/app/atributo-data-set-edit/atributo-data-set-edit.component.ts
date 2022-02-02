import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

import { AtributoDataSet, AtributoDataSetApi } from '../shared/sdk';

@Component({
  selector: 'app-atributo-data-set-edit',
  templateUrl: './atributo-data-set-edit.component.html',
  styleUrls: ['./atributo-data-set-edit.component.css']
})
export class AtributoDataSetEditComponent extends BaseEditComponent implements OnInit {

  

  constructor(protected dialogRef: MatDialogRef<AtributoDataSetEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: AtributoDataSetApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let saida: AtributoDataSet = new AtributoDataSet();
    if (this.origem) saida.dataSetId = this.origem.id;
    return saida;
  }

}
