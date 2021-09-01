import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AtivoAcao, AtivoAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-melhores-execucao-periodo',
  templateUrl: './melhores-execucao-periodo.component.html',
  styleUrls: ['./melhores-execucao-periodo.component.css']
})
export class MelhoresExecucaoPeriodoComponent implements OnInit {

  listaMelhores: AtivoAcao[];

  constructor(private srv:AtivoAcaoApi, private router: ActivatedRoute) { }

  ngOnInit() {
    this.carregaMelhores();
  }

  carregaMelhores() {
    this.router.params.subscribe((params) => {
      let idPeriodo = params['id'];
      this.srv.MelhorSimulacaoPorPeriodo(idPeriodo,14,8)
      .subscribe((result:AtivoAcao[]) => {
        this.listaMelhores = result;
        console.log('Melhores:' , this.listaMelhores);
      })
    })
    
  }

}
