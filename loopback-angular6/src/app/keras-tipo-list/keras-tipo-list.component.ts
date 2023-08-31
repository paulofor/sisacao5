import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { KerasLayerEditComponent } from '../keras-layer-edit/keras-layer-edit.component';
import { PeriodoExperimentoEditaComponent } from '../periodo-experimento-edita/periodo-experimento-edita.component';
import { KerasLayerType, KerasLayerTypeApi, PeriodoExperimento } from '../shared/sdk';

@Component({
  selector: 'app-keras-tipo-list',
  templateUrl: './keras-tipo-list.component.html',
  styleUrls: ['./keras-tipo-list.component.css']
})
export class KerasTipoListComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:KerasLayerTypeApi,public router: Router) { 
    super(dialog,srv)
  }


  getFiltro(): {} {
      return {'include' : 'kerasLayers'}
  }
  
  
  getDialogo1() {
      return KerasLayerEditComponent;
  }
}
