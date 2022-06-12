import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { RedeNeural, RedeNeuralApi } from '../shared/sdk';

@Component({
  selector: 'app-rede-neural-edita',
  templateUrl: './rede-neural-edita.component.html',
  styleUrls: ['./rede-neural-edita.component.css']
})
export class RedeNeuralEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RedeNeuralApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let novo = new RedeNeural();
    return novo;
  }

 

}
