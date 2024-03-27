import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { IndicadorRedeApi } from '../shared/sdk';

@Component({
  selector: 'app-indicador-rede-resumo',
  templateUrl: './indicador-rede-resumo.component.html',
  styleUrls: ['./indicador-rede-resumo.component.css']
})
export class IndicadorRedeResumoComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv: IndicadorRedeApi) {
    super(dialog, srv);
  }


  getFiltro(): {} {
      return {
        'order' : 'diaNumReferencia desc'
      }
  }
  

}
