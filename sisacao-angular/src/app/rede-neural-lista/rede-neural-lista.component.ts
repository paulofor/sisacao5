import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RedeNeuralEditaComponent } from '../rede-neural-edita/rede-neural-edita.component';
import { RedeNeural, RedeNeuralApi } from '../shared/sdk';

@Component({
  selector: 'app-rede-neural-lista',
  templateUrl: './rede-neural-lista.component.html',
  styleUrls: ['./rede-neural-lista.component.css']
})
export class RedeNeuralListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:RedeNeuralApi,public router: Router) { 
    super(dialog,srv)
  }

  criaItem() {
    return new RedeNeural();
  }

  getComponente() {
    return RedeNeuralEditaComponent;
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
