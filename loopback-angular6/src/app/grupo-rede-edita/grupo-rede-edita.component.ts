import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { GrupoRedeApi, GrupoRede } from '../shared/sdk';

@Component({
  selector: 'app-grupo-rede-edita',
  templateUrl: './grupo-rede-edita.component.html',
  styleUrls: ['./grupo-rede-edita.component.css']
})
export class GrupoRedeEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: GrupoRedeApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let novo = new GrupoRede();
    return novo;
  }

 

}
