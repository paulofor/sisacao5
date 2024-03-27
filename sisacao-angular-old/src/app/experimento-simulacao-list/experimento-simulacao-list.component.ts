import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { EscolhePeriodoCorrenteExperimentoComponent } from '../escolhe-periodo-corrente-experimento/escolhe-periodo-corrente-experimento.component';
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

  geraCombinacaoBtn = false;

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
        //{ 'relation' : 'periodoExperimento'}
      ] 
    }
  }

  getDialogo1() {
    return ExperimentoParametroEditComponent;
  }
  getDialogo2() {
    return EscolhePeriodoParaExperimentoComponent;
  }

  
  dialogo3(dados) {
    console.log('dialogo3.dados:' , dados);
    this.dialog.afterAllClosed.subscribe(result => {
        this.carregaTela();
    });
    this.dialog.open(this.getDialogo3(), {
        width: '800px',
        data: dados
    });
  }
  getDialogo3() : any { 
    return EscolhePeriodoCorrenteExperimentoComponent;
  }
  
  
  gerarCombinacao(item) {
    this.geraCombinacaoBtn = true;
    
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
  valida(item) {
    this.srv.ColocaEmValidacao(item.id)
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
  fecharExperimento(item) {
    this.srv.ValidarFechar(item.id)
      .subscribe((result => {
        this.carregaTela();
      }))
  }

  periodoCorrente(periodo,item) {
    //console.log('periodoAtual:' , periodo);
    //console.log('itemAtual:' , item);
    return (periodo.periodoExperimentoId==item.periodoExperimentoId);
  }
}
