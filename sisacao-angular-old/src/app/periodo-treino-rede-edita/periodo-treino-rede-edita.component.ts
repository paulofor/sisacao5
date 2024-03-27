import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { PeriodoTreinoRedeApi, PeriodoExperimento, PeriodoTreinoRede } from '../shared/sdk';

@Component({
  selector: 'app-periodo-treino-rede-edita',
  templateUrl: './periodo-treino-rede-edita.component.html',
  styleUrls: ['./periodo-treino-rede-edita.component.css']
})
export class PeriodoTreinoRedeEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: PeriodoTreinoRedeApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let periodo = new PeriodoTreinoRede();
    //periodo.permiteEditar = 1;
    return periodo;
  }

  preSubmit() {
    // dd-mm-aaaa
    // 0123456789
   
  }

}