import { Component, Inject, OnInit } from '@angular/core';
import { AmostraDadoSintetico, AmostraDadoSinteticoApi, TipoExemploTreino, TipoExemploTreinoApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

@Component({
  selector: 'app-amostra-dado-sintetico-edit',
  templateUrl: './amostra-dado-sintetico-edit.component.html',
  styleUrls: ['./amostra-dado-sintetico-edit.component.css']
})
export class AmostraDadoSinteticoEditComponent extends BaseEditComponent {

  listaTipoExemplo:TipoExemploTreino[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: AmostraDadoSinteticoApi,protected srvTipoExemplo:TipoExemploTreinoApi
  ) {
    super(dialogRef,data,servico)
  }

  criaItem() {
    let item:AmostraDadoSintetico = new AmostraDadoSintetico();
    return item;
  }

  montaCombos() {
    this.srvTipoExemplo.find()
    .subscribe((result:TipoExemploTreino[])=> {
      console.log('TipoExemplo' , result);
      this.listaTipoExemplo = result;
    })
  }
  

 
  

}
