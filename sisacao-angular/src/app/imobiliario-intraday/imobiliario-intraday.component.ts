import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { DescricaoFundoImobiliarioComponent } from '../descricao-fundo-imobiliario/descricao-fundo-imobiliario.component';
import { DetalheAluguelFundoImobiliarioComponent } from '../detalhe-aluguel-fundo-imobiliario/detalhe-aluguel-fundo-imobiliario.component';
import { FundoImobiliarioApi } from '../shared/sdk';

@Component({
  selector: 'app-imobiliario-intraday',
  templateUrl: './imobiliario-intraday.component.html',
  styleUrls: ['./imobiliario-intraday.component.css']
})
export class ImobiliarioIntradayComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv: FundoImobiliarioApi) {
    super(dialog, srv);
  }

  carregaTela() {
    this.srv.ListaIntradayFundo()
      .subscribe((result: any[]) => {
        console.log('result: ', result);
        this.listaBase = result;
        this.posCarregaLista();
      })


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
