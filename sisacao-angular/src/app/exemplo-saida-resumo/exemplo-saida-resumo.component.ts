import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { ExemploTreinoAcaoSaidaApi } from '../shared/sdk';

@Component({
  selector: 'app-exemplo-saida-resumo',
  templateUrl: './exemplo-saida-resumo.component.html',
  styleUrls: ['./exemplo-saida-resumo.component.css']
})
export class ExemploSaidaResumoComponent  extends BaseListComponent {

  processando = false;

  constructor(protected dialog: MatDialog, protected srv:ExemploTreinoAcaoSaidaApi,public router: Router) { 
    super(dialog,srv)
  }


  percentualClasse0(item) {
    return (item.classe0 / item.qtdeSaida) * 100;
  }
  percentualClasse1(item) {
    return (item.classe1 / item.qtdeSaida) * 100;
  }
  percentualResultado(item) {
    return (item.resultado / item.qtdeSaida) * 100;
  }
 
  atualiza() {
    this.carregaTela();
  }

  carregaTela() {
    this.processando = true;
    this.srv.ResumoPorRegra()
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
        this.processando = false;
        this.posCarregaLista();
    })
 }

  

}
