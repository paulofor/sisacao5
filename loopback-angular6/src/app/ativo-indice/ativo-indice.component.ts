import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { AtivoIndiceEditaComponent } from '../ativo-indice-edita/ativo-indice-edita.component';
import { AtivoIndice, AtivoIndiceApi } from '../shared/sdk';

@Component({
  selector: 'app-ativo-indice',
  templateUrl: './ativo-indice.component.html',
  styleUrls: ['./ativo-indice.component.css']
})
export class AtivoIndiceComponent implements OnInit {

  lista: AtivoIndice[];

  constructor(private srv: AtivoIndiceApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
    };
    this.srv.find(filtro)
      .subscribe((resultado: AtivoIndice[]) => {
        this.lista = resultado;
        console.log('Lista:' , this.lista);
      })

  }

  novo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carrega();
    });
    this.dialog.open(AtivoIndiceEditaComponent, {
      width: '800px',
      data: {
        item: edicao
      }
    });
  }

}
