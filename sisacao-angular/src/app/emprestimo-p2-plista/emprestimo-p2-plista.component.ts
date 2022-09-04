import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { EmprestimoP2PEditaComponent } from '../emprestimo-p2-pedita/emprestimo-p2-pedita.component';
import { EmprestimoP2PApi, EmprestimoP2P } from '../shared/sdk';

@Component({
  selector: 'app-emprestimo-p2-plista',
  templateUrl: './emprestimo-p2-plista.component.html',
  styleUrls: ['./emprestimo-p2-plista.component.css']
})
export class EmprestimoP2PListaComponent extends BaseListComponent {


  resumo: any;

  constructor(protected dialog: MatDialog, protected srv:EmprestimoP2PApi,public router: Router) { 
    super(dialog,srv)
  }

  preCarregaTela(): void {
     this.srv.ObtemResumo()
      .subscribe((result) => {
        console.log('resumo' , result);
        this.resumo = result;
      }) 
  }


  criaItem() {
    return new EmprestimoP2P();
  }

  getComponente() {
    return EmprestimoP2PEditaComponent;
  }

  getFiltro() {
    return {
      'order' : ['ativo desc' , 'dataCompra asc']
    }
  }

  getPercentual(valor:number, item) {
    return (valor / item.valorEmprestimo) * 100;
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