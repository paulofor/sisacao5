import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Ativo, AtivoCriptomoeda, AtivoCriptomoedaApi } from '../shared/sdk';

@Component({
  selector: 'app-ativo-criptomoeda',
  templateUrl: './ativo-criptomoeda.component.html',
  styleUrls: ['./ativo-criptomoeda.component.css']
})
export class AtivoCriptomoedaComponent implements OnInit {

  lista: AtivoCriptomoeda[];

  constructor(private srv: AtivoCriptomoedaApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
      'order' : 'posicao'
    };
    this.srv.find(filtro)
      .subscribe((resultado: AtivoCriptomoeda[]) => {
        this.lista = resultado;
        console.log('Lista:' , this.lista);
      })

  }

  /*
  novo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carrega();
    });
    this.dialog.open(AtivoMercadoriaEditaComponent, {
      width: '800px',
      data: {
        item: edicao
      }
    });
  }
  */

}
