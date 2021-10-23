import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { ExecucaoSimulacaoApi, PeriodoExperimento, PeriodoExperimentoApi } from '../shared/sdk';

@Component({
  selector: 'app-melhores-validacao-periodo',
  templateUrl: './melhores-validacao-periodo.component.html',
  styleUrls: ['./melhores-validacao-periodo.component.css']
})
export class MelhoresValidacaoPeriodoComponent extends BaseListComponent  {

  periodo: PeriodoExperimento;
  contaValidado = 0;

  constructor(private router: ActivatedRoute,protected dialog: MatDialog, protected srv:ExecucaoSimulacaoApi, 
    protected srvPeriodo:PeriodoExperimentoApi) {
    super(dialog, srv);
    this.contaValidado = 0;
  }


  carregaTela() {
    this.router.params.subscribe((params) => {
      let idPeriodo = params['id'];
      this.srvPeriodo.findById(idPeriodo)
        .subscribe((periodo : PeriodoExperimento) => {
          this.periodo = periodo;
        })
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
      this.contaValidado++;
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
