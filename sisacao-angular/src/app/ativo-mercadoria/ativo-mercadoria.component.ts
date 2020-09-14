import { Component, OnInit } from '@angular/core';
import { AtivoMercadoria, AtivoMercadoriaApi } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { AtivoMercadoriaEditaComponent } from '../ativo-mercadoria-edita/ativo-mercadoria-edita.component';

@Component({
  selector: 'app-ativo-mercadoria',
  templateUrl: './ativo-mercadoria.component.html',
  styleUrls: ['./ativo-mercadoria.component.css']
})
export class AtivoMercadoriaComponent implements OnInit {

  lista: AtivoMercadoria[];

  constructor(private srv: AtivoMercadoriaApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
    };
    this.srv.find(filtro)
      .subscribe((resultado: AtivoMercadoria[]) => {
        this.lista = resultado;
        console.log('Lista:' , this.lista);
      })

  }

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

}
