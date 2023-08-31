import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { KerasLossApi, KerasLoss } from '../shared/sdk';

@Component({
  selector: 'app-keras-loss-edit',
  templateUrl: './keras-loss-edit.component.html',
  styleUrls: ['./keras-loss-edit.component.css']
})
export class KerasLossEditComponent extends BaseEditComponent {


  listaTipoObjeto;
  listaTipoFuncao;

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: KerasLossApi,
     ) {
    super(dialogRef,data,servico);

    this.listaTipoObjeto =  [
      {value: 'class', viewValue: 'class'},
      {value: 'function', viewValue: 'function'},
    ];

    this.listaTipoFuncao =  [
      {value: 'Probabilistic', viewValue: 'Probabilistic losses'},
      {value: 'Regression', viewValue: 'Regression losses'},
      {value: 'Hinge', viewValue: 'Hinge losses for "maximum-margin" classification'}
    ];

  }


  criaItem() {
    let itemNovo:KerasLoss = new KerasLoss();
    return itemNovo;
  }


}


