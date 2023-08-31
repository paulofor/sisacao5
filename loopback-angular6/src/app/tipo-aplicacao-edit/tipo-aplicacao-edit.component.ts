import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { TipoAplicacaoApi, TipoAplicacao, InstituicaoFinanceiraApi, InstituicaoFinanceira } from '../shared/sdk';

@Component({
  selector: 'app-tipo-aplicacao-edit',
  templateUrl: './tipo-aplicacao-edit.component.html',
  styleUrls: ['./tipo-aplicacao-edit.component.css']
})
export class TipoAplicacaoEditComponent extends BaseEditComponent {


  listaInstituicao : InstituicaoFinanceira[];

  constructor(protected dialogRef: MatDialogRef<TipoAplicacaoEditComponent>, private srvInstituicao:InstituicaoFinanceiraApi
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: TipoAplicacaoApi,
  ) {
    super(dialogRef,data,servico);
  }

  criaItem() {
    return new TipoAplicacao();
  }


  montaCombos() {
    this.srvInstituicao.find({'order' : 'nome'})
      .subscribe((result:InstituicaoFinanceira[]) => {
        this.listaInstituicao = result;
      });

  }

  preSubmit() {
    delete this.item['instituicaoFinanceira'];
    //if (!this.item.dataCriacao) {
    //  this.item.dataCriacao = new Date();
    //}
  }
}
