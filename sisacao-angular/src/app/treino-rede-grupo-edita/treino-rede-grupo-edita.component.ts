import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TreinoRedeApi } from '../shared/sdk';

@Component({
  selector: 'app-treino-rede-grupo-edita',
  templateUrl: './treino-rede-grupo-edita.component.html',
  styleUrls: ['./treino-rede-grupo-edita.component.css']
})
export class TreinoRedeGrupoEditaComponent  extends BaseEditComponent {




  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TreinoRedeApi
    
  ) {
    super(dialogRef,data,servico);
  }



 


}