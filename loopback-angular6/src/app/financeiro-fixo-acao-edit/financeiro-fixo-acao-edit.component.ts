import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ExperimentoSimulacaoApi, RegraSimulacaoApi, GrupoAcaoApi, ExperimentoSimulacao, RegraSimulacao, GrupoAcao, FinanceiroAcaoFixo, FinanceiroAcaoFixoApi } from '../shared/sdk';
import * as moment from 'moment';

@Component({
  selector: 'app-financeiro-fixo-acao-edit',
  templateUrl: './financeiro-fixo-acao-edit.component.html',
  styleUrls: ['./financeiro-fixo-acao-edit.component.css']
})
export class FinanceiroFixoAcaoEditComponent  extends BaseEditComponent {

 
  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: FinanceiroAcaoFixoApi,
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new FinanceiroAcaoFixo();
  }



  preSubmit() {
    this.item.dataAlteracao = (moment(new Date())).format('YYYY-MM-DD HH:mm:ss');
    this.item.instituicaoFinanceiraId = 3;
    this.item.tipoAplicacaoId = 2;
  }

}
