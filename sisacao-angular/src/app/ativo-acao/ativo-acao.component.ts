import { Component, OnInit } from '@angular/core';
import { AtivoAcaoApi } from '../shared/sdk';
import { AtivoAcaoEditaComponent } from '../ativo-acao-edita/ativo-acao-edita.component';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-ativo-acao',
  templateUrl: './ativo-acao.component.html',
  styleUrls: ['./ativo-acao.component.css']
})
export class AtivoAcaoComponent implements OnInit {

  lista: AtivoAcaoApi[];

  constructor(private srv: AtivoAcaoApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
    };
    this.srv.find(filtro)
      .subscribe((resultado: AtivoAcaoApi[]) => {
        this.lista = resultado;
        console.log('Lista:' , this.lista);
      })

  }

  novo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carrega();
    });
    this.dialog.open(AtivoAcaoEditaComponent, {
      width: '800px',
      data: {
        item: edicao
      }
    });
  }



}
