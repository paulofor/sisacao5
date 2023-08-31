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

  onChangeEntrada1(event) {
    //console.log('event:', event);
    for (let i=0;i<this.listaTipoExemplo.length;i++) {
      if (event.value==this.listaTipoExemplo[i].id) {
        //console.log('escolhido1', this.listaTipoExemplo[i]);
        let pontos = 15 * this.listaTipoExemplo[i].qtdeDias;
        this.item.entrada1 = pontos;
      }
    }
  }
  onChangeEntrada2(event) {
    //console.log('event:', event);
    for (let i=0;i<this.listaTipoExemplo.length;i++) {
      if (event.value==this.listaTipoExemplo[i].id) {
        //console.log('escolhido1', this.listaTipoExemplo[i]);
        let pontos = 15 * this.listaTipoExemplo[i].qtdeDias;
        this.item.entrada2 = pontos;
      }
    }
  }

}
