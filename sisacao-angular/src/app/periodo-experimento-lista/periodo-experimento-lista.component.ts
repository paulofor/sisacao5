import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { PeriodoExperimentoEditaComponent } from '../periodo-experimento-edita/periodo-experimento-edita.component';
import { PeriodoExperimento, PeriodoExperimentoApi } from '../shared/sdk';

@Component({
  selector: 'app-periodo-experimento-lista',
  templateUrl: './periodo-experimento-lista.component.html',
  styleUrls: ['./periodo-experimento-lista.component.css']
})
export class PeriodoExperimentoListaComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:PeriodoExperimentoApi) { 
    super(dialog,srv)
  }

  criaItem() {
    return new PeriodoExperimento();
  }

  getComponente() {
    return PeriodoExperimentoEditaComponent;
  }

}
