import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { RedeNeural, RedeNeuralApi, TipoExemploTreino, TipoExemploTreinoApi } from '../shared/sdk';

@Component({
  selector: 'app-rede-neural-edita',
  templateUrl: './rede-neural-edita.component.html',
  styleUrls: ['./rede-neural-edita.component.css']
})
export class RedeNeuralEditaComponent extends BaseEditComponent {

  listaTipoExemplo:TipoExemploTreino[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: RedeNeuralApi,protected srvTipoExemplo:TipoExemploTreinoApi
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let novo = new RedeNeural();
    return novo;
  }

  montaCombos() {
    this.srvTipoExemplo.find()
      .subscribe((result:TipoExemploTreino[])=> {
        console.log('TipoExemplo' , result);
        this.listaTipoExemplo = result;
      })
  }
  preSubmit() {
    delete this.item['tipoExemploTreino1'];
    delete this.item['tipoExemploTreino2'];
  }

}
