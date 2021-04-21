import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { EscolhePeriodoParaExperimentoComponent } from '../escolhe-periodo-para-experimento/escolhe-periodo-para-experimento.component';
import { ExperimentoParametroEditComponent } from '../experimento-parametro-edit/experimento-parametro-edit.component';
import { ExperimentoSimulacaoEditComponent } from '../experimento-simulacao-edit/experimento-simulacao-edit.component';
import { ExperimentoAcaoApi, ExperimentoSimulacao, ExperimentoSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-experimento-simulacao-list',
  templateUrl: './experimento-simulacao-list.component.html',
  styleUrls: ['./experimento-simulacao-list.component.css']
})
export class ExperimentoSimulacaoListComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:ExperimentoSimulacaoApi) { 
    super(dialog,srv);
  }

  getComponente() {
    return ExperimentoSimulacaoEditComponent;
  }

  getFiltro() {
    return {
      'order' : 'id desc',
      'include' : [
        { 'relation' : 'regraSimulacao' } ,
        { 'relation' : 'experimentoParametros' , 'scope' : {'include' : 'parametroRegra'}},
        { 'relation' : 'grupoAcao'},
        { 'relation' : 'experimentoSimulacaoPeriodos' , 'scope' : {'include' : 'periodoExperimento'} }
      ] 
    }
  }

  getDialogo1() {
    return ExperimentoParametroEditComponent;
  }
  getDialogo2() {
    return EscolhePeriodoParaExperimentoComponent;
  }

  gerarCombinacao(item) {
    this.srv.GerarCombinacoes(item.id)
      .subscribe(result => {
        item.quantidadeCombinacao = result.quantidade;
      })
  }

  executa(item) {
    this.srv.ColocaEmExecucao(item.id)
      .subscribe(result => {
        this.carregaTela();
      })
  }
  ajustar() {
    this.srv.ProcessaPermiteEdicaoExperimento()
      .subscribe((result => {
        this.carregaTela();
      }))
  }
}
