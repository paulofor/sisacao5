import { Component, OnInit } from '@angular/core';
import { AtivoOpcao, AtivoOpcaoApi } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { AtivoOpcaoEditaComponent } from '../ativo-opcao-edita/ativo-opcao-edita.component';

@Component({
  selector: 'app-ativo-opcao',
  templateUrl: './ativo-opcao.component.html',
  styleUrls: ['./ativo-opcao.component.css']
})
export class AtivoOpcaoComponent implements OnInit {

  lista: AtivoOpcao[];

  constructor(private srv: AtivoOpcaoApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
    };
    this.srv.find(filtro)
      .subscribe((resultado: AtivoOpcao[]) => {
        this.lista = resultado;
        console.log('Lista:' , this.lista);
      })

  }

  novo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carrega();
    });
    this.dialog.open(AtivoOpcaoEditaComponent, {
      width: '800px',
      data: {
        item: edicao
      }
    });
  }

}
