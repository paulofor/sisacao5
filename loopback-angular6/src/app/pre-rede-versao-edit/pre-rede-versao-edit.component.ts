import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TipoExemploTreino, RedeNeuralApi, TipoExemploTreinoApi, RedeNeural, PreRedeNeuralApi, VersaoPreRedeApi, VersaoPreRede } from '../shared/sdk';

@Component({
  selector: 'app-pre-rede-versao-edit',
  templateUrl: './pre-rede-versao-edit.component.html',
  styleUrls: ['./pre-rede-versao-edit.component.css']
})
export class PreRedeVersaoEditComponent extends BaseEditComponent {

  
  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: VersaoPreRedeApi
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let novo = new VersaoPreRede();
    novo['preRedeNeuralId'] = this.origem.id;
    return novo;
  }

  
  
  
  

}
