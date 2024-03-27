import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { PeriodoExperimento, PeriodoExperimentoApi } from '../shared/sdk';

@Component({
  selector: 'app-periodo-experimento-edita',
  templateUrl: './periodo-experimento-edita.component.html',
  styleUrls: ['./periodo-experimento-edita.component.css']
})
export class PeriodoExperimentoEditaComponent extends BaseEditComponent {

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: PeriodoExperimentoApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    let periodo = new PeriodoExperimento();
    periodo.permiteEditar = 1;
    return periodo;
  }

  preSubmit() {
    // dd-mm-aaaa
    // 0123456789
    let dia = this.item.dataStrInicial.substring(0,2);
    let mes = this.item.dataStrInicial.substring(3,5);
    let ano = this.item.dataStrInicial.substring(6);
    let dataNum = ano + mes + dia;
    this.item.dataNumInicial = dataNum;
    dia = this.item.dataStrFinal.substring(0,2);
    mes = this.item.dataStrFinal.substring(3,5);
    ano = this.item.dataStrFinal.substring(6);
    dataNum = ano + mes + dia;
    this.item.dataNumFinal = dataNum;
  }

}




