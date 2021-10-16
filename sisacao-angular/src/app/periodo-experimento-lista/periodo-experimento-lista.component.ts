import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { PeriodoExperimentoEditaComponent } from '../periodo-experimento-edita/periodo-experimento-edita.component';
import { PeriodoExperimento, PeriodoExperimentoApi } from '../shared/sdk';

@Component({
  selector: 'app-periodo-experimento-lista',
  templateUrl: './periodo-experimento-lista.component.html',
  styleUrls: ['./periodo-experimento-lista.component.css']
})
export class PeriodoExperimentoListaComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:PeriodoExperimentoApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new PeriodoExperimento();
  }

  getComponente() {
    return PeriodoExperimentoEditaComponent;
  }

  getFiltro() {
    return {
      'order' : 'dataNumFinal desc'
    }
  }

  melhores(item){
    this.router.navigate(['melhoresExecucaoPeriodo' , item.id]);
  }

  monitoradas(item){
    this.router.navigate(['valorMonitoriaPeriodo' , item.id]);
  }

  validacoes(item) {
    this.router.navigate(['melhoresValidacaoPeriodo', item.id])
  }

}
