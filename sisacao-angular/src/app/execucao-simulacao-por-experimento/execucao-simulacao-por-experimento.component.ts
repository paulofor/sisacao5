import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { interval, Subscription } from 'rxjs';
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
  percentual: number;

  private updateSubscription: Subscription;

  constructor(private srv: ExperimentoSimulacaoApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carrega();
    this.updateSubscription = interval(60000)
      .subscribe((val) => { 
        this.carrega()
      });
  }

  carrega() {
    this.router.params.subscribe((params) => {
      let idExperimento = params['id'];
      console.log('ID' , idExperimento);
      //let filtro = {
      //  'order' : 'resultado desc',
      //  'limit' : 140,
      //  'include' : {'relation' : 'combinacaoParametro' , 'scope' : {'include' : 'regraSimulacao'}},
      //  'where' : {'experimentoSimulacaoId' : idExperimento}
      //}
      this.srv.ObtemExecucao(idExperimento)
        .subscribe((result) => {
          console.log('Result:' , result);
          this.lista = result.melhoresExecucao;
          this.qtdeProcessada = result.combinacaoProcessada;
          this.experimento = result.experimento;
          this.percentual = (this.qtdeProcessada / this.experimento.quantidadeCombinacao) * 100;
          //this.lista = 2;
        })
    })
  }

}
