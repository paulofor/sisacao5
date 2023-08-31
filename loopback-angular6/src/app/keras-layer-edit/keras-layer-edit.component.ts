import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { InstituicaoFinanceira, KerasLayer, KerasLayerApi, KerasLayerType, KerasLayerTypeApi, TipoAplicacao } from '../shared/sdk';

@Component({
  selector: 'app-keras-layer-edit',
  templateUrl: './keras-layer-edit.component.html',
  styleUrls: ['./keras-layer-edit.component.css']
})
export class KerasLayerEditComponent extends BaseEditComponent {

  listaTipo : KerasLayerType[];
  listaTipoObjeto


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: KerasLayerApi,
     protected srvTipo: KerasLayerTypeApi
  ) {
    super(dialogRef,data,servico);

    this.listaTipoObjeto =  [
      {value: 'class', viewValue: 'class'},
      {value: 'property', viewValue: 'property'},
      {value: 'method', viewValue: 'method'},
      {value: 'function', viewValue: 'function'},
      {value: 'layer', viewValue: 'layer'},
      {value: 'object', viewValue: 'object'}
    ];
  }


  criaItem() {
    let itemNovo:KerasLayer = new KerasLayer();
    itemNovo.kerasLayerTypeId = this.origem.id;
    return itemNovo;
  }


  

  montaCombos() {
    this.srvTipo.find()
      .subscribe((result:KerasLayerType[])=> {
        console.log('KerasLayerType' , result);
        this.listaTipo = result;
    })
   
  }

  preSubmit() {
    //delete this.item['instituicaoFinanceira'];
  }

}


