import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { ValorMesInstituicaoTipoApi, ValorMesInstituicaoTipo, InstituicaoFinanceira, InstituicaoFinanceiraApi, TipoAplicacao, TipoAplicacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-valor-mes-saldo-edit',
  templateUrl: './valor-mes-saldo-edit.component.html',
  styleUrls: ['./valor-mes-saldo-edit.component.css']
})
export class ValorMesSaldoEditComponent extends BaseEditComponent {

  listaTipo : TipoAplicacao[];
  listaInstituicao : InstituicaoFinanceira[];


  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ValorMesInstituicaoTipoApi,
    protected srvInstituicao:InstituicaoFinanceiraApi, protected srvTipo: TipoAplicacaoApi
  ) {
    super(dialogRef,data,servico)
  }

  criaItem() {
    let item:ValorMesInstituicaoTipo = new ValorMesInstituicaoTipo();
    item.dataReferenciaNum = this.dataReferencia();
    return item;
  }
  

  dataReferencia() {
    var d = new Date();
    d.setMonth(d.getMonth() - 1);
    let mes = ("0" + (d.getMonth() + 1)).slice(-2);
    return Number(String(d.getFullYear()) + String(mes));
  }
  
  preSubmit() {
    delete this.item['instituicaoFinanceira'];
    delete this.item['tipoAplicacao'];
  }

  montaCombos() {
    let filtro = {'order' : 'nome'}
    this.srvInstituicao.find(filtro)
      .subscribe((result:InstituicaoFinanceira[])=> {
        console.log('InstituicaoFinanceira' , result);
        this.listaInstituicao = result;
    })
    this.srvTipo.find(filtro)
      .subscribe((result:TipoAplicacao[])=> {
        console.log('TipoAplicacao' , result);
        this.listaTipo = result;
    })
  }
}
