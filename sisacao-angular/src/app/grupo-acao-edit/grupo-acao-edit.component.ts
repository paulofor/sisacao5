import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { EscolheAcaoGrupoEditComponent } from '../escolhe-acao-grupo-edit/escolhe-acao-grupo-edit.component';
import { GrupoAcaoApi, GrupoAcao } from '../shared/sdk';

@Component({
  selector: 'app-grupo-acao-edit',
  templateUrl: './grupo-acao-edit.component.html',
  styleUrls: ['./grupo-acao-edit.component.css']
})
export class GrupoAcaoEditComponent  extends BaseEditComponent {

 
  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: GrupoAcaoApi
    
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new GrupoAcao();
  }

  getDialogo1() : any {
    return EscolheAcaoGrupoEditComponent;
  }

}
