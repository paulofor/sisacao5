import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { ExecucaoSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-melhores-validacao-periodo',
  templateUrl: './melhores-validacao-periodo.component.html',
  styleUrls: ['./melhores-validacao-periodo.component.css']
})
export class MelhoresValidacaoPeriodoComponent extends BaseListComponent  {

  constructor(private router: ActivatedRoute,protected dialog: MatDialog, protected srv:ExecucaoSimulacaoApi) {
    super(dialog, srv);
  }


  carregaTela() {
    this.router.params.subscribe((params) => {
      let idPeriodo = params['id'];
      this.srv.MelhorValidacaoPeriodo(idPeriodo)
          .subscribe((result:any[]) => {
            console.log('result: ' , result);
            this.listaBase = result;
          })
      })
  }

  placarValidacao(item) {
    let placar = '-'
    if (item.execucaoSimulacaoValidacaos.length>0) {
      placar = item.execucaoSimulacaoValidacaos[0].quantidadeLucro + ' x ' + item.execucaoSimulacaoValidacaos[0].quantidadePrejuizo;
    }
    return placar;
  }
 
  /*
  getComponente() {
    return DataSetEditComponent;
  }

  getDialogo1() {
    return AtributoDataSetEditComponent;
  }
  getDialogo2() {
    return DataSetCreateSqlComponent;
  }
  */



}
