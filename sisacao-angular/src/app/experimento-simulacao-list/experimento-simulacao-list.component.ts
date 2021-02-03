import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { ExperimentoAcaoApi, ExperimentoSimulacao } from '../shared/sdk';

@Component({
  selector: 'app-experimento-simulacao-list',
  templateUrl: './experimento-simulacao-list.component.html',
  styleUrls: ['./experimento-simulacao-list.component.css']
})
export class ExperimentoSimulacaoListComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:ExperimentoAcaoApi) { 
    super(dialog,srv);
  }

  getComponente() {
    return new ExperimentoSimulacao();
  }

}
