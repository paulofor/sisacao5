import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { AmostraDadoSintetico, AmostraDadoSinteticoApi, ExperimentoPreRede, ExperimentoPreRedeApi, VersaoPreRede, VersaoPreRedeApi } from '../shared/sdk';
import { BaseEditComponent } from '../base-component/base-edit-component';

@Component({
  selector: 'app-cria-experimento-pre-rede-edit',
  templateUrl: './cria-experimento-pre-rede-edit.component.html',
  styleUrls: ['./cria-experimento-pre-rede-edit.component.css']
})
export class CriaExperimentoPreRedeEditComponent extends BaseEditComponent implements OnInit {

  origem: VersaoPreRede;
  listaEntrada1:AmostraDadoSintetico[];
  listaEntrada2:AmostraDadoSintetico[];

  constructor(protected dialogRef: MatDialogRef<CriaExperimentoPreRedeEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: ExperimentoPreRedeApi, 
    private srvAmostra:AmostraDadoSinteticoApi
  ) {
    super(dialogRef, data, servico);
  }


  criaItem() {
    let novo:ExperimentoPreRede =  new ExperimentoPreRede();
    novo.versaoPreRedeId = this.origem.id;
    return novo;
  }

  montaCombos(): void {
    this.srvAmostra.ListaDisponivelParaPreRedeVersao1(this.origem.id)
    .subscribe((result:AmostraDadoSintetico[]) => {
      console.log('Lista Disponivel Amostras' , result);
      this.listaEntrada1 = result;
    })
    this.srvAmostra.ListaDisponivelParaPreRedeVersao2(this.origem.id)
    .subscribe((result:AmostraDadoSintetico[]) => {
      console.log('Lista Disponivel Amostras' , result);
      this.listaEntrada2 = result;
    })
  }

 
}
