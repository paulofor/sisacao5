import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { RegraSimulacao, RegraSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-regra-simulacao-edit',
  templateUrl: './regra-simulacao-edit.component.html',
  styleUrls: ['./regra-simulacao-edit.component.css']
})
export class RegraSimulacaoEditComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RegraSimulacaoApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new RegraSimulacao();
  }

  preSubmit() {
    if (!this.item.dataCriacao) {
      this.item.dataCriacao = new Date();
    }
  }
}
