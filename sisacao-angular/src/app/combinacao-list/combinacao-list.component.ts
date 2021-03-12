import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { CombinacaoParametroApi, ParametroRegraApi } from '../shared/sdk';

@Component({
  selector: 'app-combinacao-list',
  templateUrl: './combinacao-list.component.html',
  styleUrls: ['./combinacao-list.component.css']
})
export class CombinacaoListComponent extends BaseListComponent {

  idExperimento: number;

  constructor(protected dialog: MatDialog, protected srv:ParametroRegraApi, private router: ActivatedRoute ) { 
    super(dialog,srv);
  }

 


  carregaTela() {
    this.router.params.subscribe((params) => {
      this.idExperimento = params['id'];
      this.srv.ObtemPorExperimentoComValor(this.idExperimento)
        .subscribe((result) => {
          this.listaBase = result;
          console.log("ListaBase: " , this.listaBase);
        })
    });
  }

  listaValor(valores) : string {
    let saida = '';
    for (let i=0; i<valores.length; i++) {
      saida += valores[i].valorParametro + ', '
    }
    return saida;
  }
}
