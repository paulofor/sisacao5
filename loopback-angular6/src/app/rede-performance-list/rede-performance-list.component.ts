import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RedeNeuralEditaComponent } from '../rede-neural-edita/rede-neural-edita.component';
import { RedeNeuralApi, RedeNeural } from '../shared/sdk';

@Component({
  selector: 'app-rede-performance-list',
  templateUrl: './rede-performance-list.component.html',
  styleUrls: ['./rede-performance-list.component.css']
})
export class RedePerformanceListComponent extends BaseListComponent {



  constructor(protected dialog: MatDialog, protected srv:RedeNeuralApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new RedeNeural();
  }

  getComponente() {
    return RedeNeuralEditaComponent;
  }

  getFiltro() {
    return {'include' : ['tipoExemploTreino1' , 'tipoExemploTreino2']}
  }

 

  /*
  edita(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
        this.carregaTela();
    });
    this.dialog.open(this.getComponente(), {
        width: '800px',
        data: {
            item: edicao
        }
    });
  }
  */
}
