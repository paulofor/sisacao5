import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { GrupoAcao, GrupoAcaoApi, TipoExemploTreino, TipoExemploTreinoApi } from '../shared/sdk';

@Component({
  selector: 'app-tipo-exemplo-treino-edit',
  templateUrl: './tipo-exemplo-treino-edit.component.html',
  styleUrls: ['./tipo-exemplo-treino-edit.component.css']
})
export class TipoExemploTreinoEditComponent extends BaseEditComponent {



  constructor(protected dialogRef: MatDialogRef<TipoExemploTreinoEditComponent>, 
     @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TipoExemploTreinoApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    return new TipoExemploTreino();
  }


 
}
