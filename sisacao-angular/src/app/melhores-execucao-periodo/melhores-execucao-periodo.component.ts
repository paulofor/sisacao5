import { Component, OnInit } from '@angular/core';
import { AtivoAcao, AtivoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-melhores-execucao-periodo',
  templateUrl: './melhores-execucao-periodo.component.html',
  styleUrls: ['./melhores-execucao-periodo.component.css']
})
export class MelhoresExecucaoPeriodoComponent implements OnInit {

  listaMelhores: AtivoAcao[];

  constructor(private srv:AtivoAcaoApi) { }

  ngOnInit() {
    this.carregaMelhores();
  }

  carregaMelhores() {
    this.srv.MelhorSimulacaoPorPeriodo(3,39,8)
      .subscribe((result:AtivoAcao[]) => {
        this.listaMelhores = result;
        console.log('Melhores:' , this.listaMelhores);
      })
  }

}
