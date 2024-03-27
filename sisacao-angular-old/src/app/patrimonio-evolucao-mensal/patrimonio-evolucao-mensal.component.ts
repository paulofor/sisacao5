import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TipoAplicacaoApi, ValorMesInstituicaoTipoApi } from '../shared/sdk';

@Component({
  selector: 'app-patrimonio-evolucao-mensal',
  templateUrl: './patrimonio-evolucao-mensal.component.html',
  styleUrls: ['./patrimonio-evolucao-mensal.component.css']
})
export class PatrimonioEvolucaoMensalComponent extends BaseListComponent  {

  constructor(protected dialog: MatDialog, protected srv:TipoAplicacaoApi) {
    super(dialog, srv);
  }

  carregaTela() {
    this.srv.TotaisPorMes()
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
        this.posCarregaLista();
    })
  }

 

}
