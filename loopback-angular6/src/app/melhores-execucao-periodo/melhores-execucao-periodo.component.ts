import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AtivoAcao, AtivoAcaoApi, PeriodoExperimento, PeriodoExperimentoApi } from '../shared/sdk';

@Component({
  selector: 'app-melhores-execucao-periodo',
  templateUrl: './melhores-execucao-periodo.component.html',
  styleUrls: ['./melhores-execucao-periodo.component.css']
})
export class MelhoresExecucaoPeriodoComponent implements OnInit {

  listaMelhores: AtivoAcao[];

  constructor(private srv:AtivoAcaoApi, private router: ActivatedRoute, private srvPeriodo: PeriodoExperimentoApi) { }

  ngOnInit() {
    this.carregaMelhores();
  }

  carregaMelhores() {
    this.router.params.subscribe((params) => {
      let idPeriodo = params['id'];
      this.srvPeriodo.findById(idPeriodo)
        .subscribe((periodo:PeriodoExperimento)=> {
          this.srv.MelhorSimulacaoPorPeriodo(idPeriodo,periodo.minimoPontoExibicao,12)
          .subscribe((result:AtivoAcao[]) => {
            this.listaMelhores = result;
            console.log('Melhores:' , this.listaMelhores);
          })
        }) 
     
    })
    
  }

}
