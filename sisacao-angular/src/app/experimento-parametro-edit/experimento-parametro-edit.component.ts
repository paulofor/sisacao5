import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ExperimentoParametroApi } from '../shared/sdk';

@Component({
  selector: 'app-experimento-parametro-edit',
  templateUrl: './experimento-parametro-edit.component.html',
  styleUrls: ['./experimento-parametro-edit.component.css']
})
export class ExperimentoParametroEditComponent  extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoParametroApi
    
  ) {
    super(dialogRef,data,servico);
  }

  

}
