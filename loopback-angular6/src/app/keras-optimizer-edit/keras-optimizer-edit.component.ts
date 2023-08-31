import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { KerasOptimizer, KerasOptimizerApi } from '../shared/sdk';

@Component({
  selector: 'app-keras-optimizer-edit',
  templateUrl: './keras-optimizer-edit.component.html',
  styleUrls: ['./keras-optimizer-edit.component.css']
})
export class KerasOptimizerEditComponent extends BaseEditComponent {


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: KerasOptimizerApi,
     ) {
    super(dialogRef,data,servico);

  }


  criaItem() {
    let itemNovo:KerasOptimizer = new KerasOptimizer();
    return itemNovo;
  }


}
