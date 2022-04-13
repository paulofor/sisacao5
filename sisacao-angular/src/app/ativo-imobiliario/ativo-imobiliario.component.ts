import { Component, OnInit } from '@angular/core';
import { AtivoImobiliarioApi, AtivoImobiliario, FundoImobiliario, FundoImobiliarioApi } from '../shared/sdk';
import { MatDialog } from '@angular/material';
import { AtivoImobiliarioEditaComponent } from '../ativo-imobiliario-edita/ativo-imobiliario-edita.component';
import { DescricaoFundoImobiliarioComponent } from '../descricao-fundo-imobiliario/descricao-fundo-imobiliario.component';
import { DetalheAluguelFundoImobiliarioComponent } from '../detalhe-aluguel-fundo-imobiliario/detalhe-aluguel-fundo-imobiliario.component';


@Component({
  selector: 'app-ativo-imobiliario',
  templateUrl: './ativo-imobiliario.component.html',
  styleUrls: ['./ativo-imobiliario.component.css']
})
export class AtivoImobiliarioComponent implements OnInit {

  lista: FundoImobiliario[];

  constructor(private srv: FundoImobiliarioApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carrega();
  }

  carrega() {
    const filtro = { 
    };
    this.srv.find(filtro)
      .subscribe((resultado: FundoImobiliario[]) => {
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


  abreExplicacao(itemCorrente) {
    this.dialog.open(DescricaoFundoImobiliarioComponent, {
      width: '600px',
      height: '400px',
      data: {
        item: itemCorrente
      }
    });
  }

  abreAluguel(itemCorrente) {
    this.dialog.open(DetalheAluguelFundoImobiliarioComponent, {
      width: '900px',
      height: '600px',
      data: {
        item: itemCorrente
      }
    });
  }

}


