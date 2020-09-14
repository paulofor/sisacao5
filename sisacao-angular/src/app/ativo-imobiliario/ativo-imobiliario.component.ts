import { Component, OnInit } from '@angular/core';
import { AtivoImobiliarioApi, AtivoImobiliario } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { AtivoImobiliarioEditaComponent } from '../ativo-imobiliario-edita/ativo-imobiliario-edita.component';

@Component({
  selector: 'app-ativo-imobiliario',
  templateUrl: './ativo-imobiliario.component.html',
  styleUrls: ['./ativo-imobiliario.component.css']
})
export class AtivoImobiliarioComponent implements OnInit {

  lista: AtivoImobiliario[];

  constructor(private srv: AtivoImobiliarioApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
    };
    this.srv.find(filtro)
      .subscribe((resultado: AtivoImobiliario[]) => {
        this.lista = resultado;
        console.log('Lista:' , this.lista);
      })

  }

  novo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carrega();
    });
    this.dialog.open(AtivoImobiliarioEditaComponent, {
      width: '800px',
      data: {
        item: edicao
      }
    });
  }

}
