import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { InstituicaoFinanceira, InstituicaoFinanceiraApi, ValorAplicado, ValorAplicadoApi } from '../shared/sdk';

@Component({
  selector: 'app-alocacao-movimentacao-edita',
  templateUrl: './alocacao-movimentacao-edita.component.html',
  styleUrls: ['./alocacao-movimentacao-edita.component.css']
})
export class AlocacaoMovimentacaoEditaComponent extends BaseEditComponent {

  listaInstituicao:InstituicaoFinanceira[];
 

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ValorAplicadoApi,
    private srvInstituicao: InstituicaoFinanceiraApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new ValorAplicado();
  }

  montaCombos() {
    this.srvInstituicao.find({'order' : 'nome'})
      .subscribe((result:InstituicaoFinanceira[]) => {
        this.listaInstituicao = result;
      });
  }

  onSubmit() {
    this.preSubmit();
    console.log('Submit(BaseEdit):' , this.item);
    this.item.tipoAplicacaoId = this.item.id;
    this.servico.InsereMovimentacao(this.item, (err, obj) => {
      console.log("Erro:" + err);
    }).subscribe((e: any) => {
      console.log(JSON.stringify(e));
      this.closeDialog();
    });

  }

  preSubmit() {
    //delete this.item['experimentoParametros'];
  }

}
