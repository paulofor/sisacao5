import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExecucaoSimulacao, ExecucaoSimulacaoApi, ExperimentoAcaoApi, ExperimentoSimulacao, ExperimentoSimulacaoApi } from '../shared/sdk';

@Component({
  selector: 'app-execucao-simulacao-por-experimento',
  templateUrl: './execucao-simulacao-por-experimento.component.html',
  styleUrls: ['./execucao-simulacao-por-experimento.component.css']
})
export class ExecucaoSimulacaoPorExperimentoComponent implements OnInit {

  lista: ExecucaoSimulacao[];
  qtdeProcessada: number;
  experimento: ExperimentoSimulacao;

  constructor(private srv: ExperimentoSimulacaoApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    this.router.params.subscribe((params) => {
      let idExperimento = params['id'];
      //let filtro = {
      //  'order' : 'resultado desc',
      //  'limit' : 140,
      //  'include' : {'relation' : 'combinacaoParametro' , 'scope' : {'include' : 'regraSimulacao'}},
      //  'where' : {'experimentoSimulacaoId' : idExperimento}
      //}
      this.srv.ObtemExecucao(idExperimento)
        .subscribe((this.experimento,this.lista,this.qtdeProcessada) => {
          this.lista = result;
        })
    })
  }

}
