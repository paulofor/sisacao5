import { Component, Inject, OnInit } from '@angular/core';
import { FechamentoRegraDia, FechamentoRegraDiaApi, GrupoAcao, GrupoAcaoApi, RegraProjecao, RegraProjecaoApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';

@Component({
  selector: 'app-fechamento-regra-dia-edit',
  templateUrl: './fechamento-regra-dia-edit.component.html',
  styleUrls: ['./fechamento-regra-dia-edit.component.css']
})
export class FechamentoRegraDiaEditComponent extends BaseEditComponent {

  listaGrupoAcao:GrupoAcao[];
  listaRegraProjecao:RegraProjecao[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: FechamentoRegraDiaApi,
    private srvGrupoAcao:GrupoAcaoApi, private srvRegraProjecao:RegraProjecaoApi
  ) {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new FechamentoRegraDia();
  }

  montaCombos(): void {
    this.srvGrupoAcao.find()
      .subscribe((result:GrupoAcao[]) => {
        this.listaGrupoAcao = result;
      })
  }

  preSubmit() {
  }

}
