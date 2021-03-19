import { Component, OnInit } from '@angular/core';
import { BaseListComponent } from '../base-component/base-list-component';
import { ExecucaoSimulacao, ExecucaoSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-execucao-simulacao-monitorada',
  templateUrl: './execucao-simulacao-monitorada.component.html',
  styleUrls: ['./execucao-simulacao-monitorada.component.css']
})
export class ExecucaoSimulacaoMonitoradaComponent extends BaseListComponent{

  constructor(protected srv:ExecucaoSimulacaoApi) {
    super(null, srv)
  }

  getFiltro() {
    return {'where' : {'monitorar' : 1}}
  }

  getValorLucro(item:ExecucaoSimulacao) {

  }

  getValorPrejuizo(item:ExecucaoSimulacao) {
    
  }

}
