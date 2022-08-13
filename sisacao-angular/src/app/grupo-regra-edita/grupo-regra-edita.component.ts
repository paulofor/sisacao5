import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { GrupoRegraApi, GrupoRegra } from '../shared/sdk';

@Component({
  selector: 'app-grupo-regra-edita',
  templateUrl: './grupo-regra-edita.component.html',
  styleUrls: ['./grupo-regra-edita.component.css']
})
export class GrupoRegraEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: GrupoRegraApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let novo = new GrupoRegra();
    return novo;
  }

 

}
