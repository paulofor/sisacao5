import { Component, OnInit} from '@angular/core';
import { MatDialog } from '@angular/material';
import { AtivoCriptomoeda, AtivoCriptomoedaApi } from '../shared/sdk';

@Component({
  selector: 'app-ativo-criptomoeda-foxbit',
  templateUrl: './ativo-criptomoeda-foxbit.component.html',
  styleUrls: ['./ativo-criptomoeda-foxbit.component.css']
})
export class AtivoCriptomoedaFoxbitComponent implements OnInit {

  lista: AtivoCriptomoeda[];

  constructor(private srv: AtivoCriptomoedaApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
      'where' : {'foxbit' : 1 },
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
