import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { StartupFundo, StartupFundoApi, StartupInvestimento, StartupInvestimentoApi } from '../shared/sdk';

@Component({
  selector: 'app-startup-investimento-edit',
  templateUrl: './startup-investimento-edit.component.html',
  styleUrls: ['./startup-investimento-edit.component.css']
})
export class StartupInvestimentoEditComponent extends BaseEditComponent {

  listaFundo: StartupFundo[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: StartupInvestimentoApi,private srvFundo:StartupFundoApi
  ) {
    super(dialogRef,data,servico);
  }
 

  montaCombos() {
    this.srvFundo.find({'order' : 'nome'})
      .subscribe((result:StartupFundo[]) => {
        this.listaFundo = result;
      })
  }

  criaItem() {
    let novo: StartupInvestimento = new StartupInvestimento();
    novo.startupEmpresaId = this.origem.id;
    console.log('Item para inserir: ' , novo);
    return novo;
  }

}
