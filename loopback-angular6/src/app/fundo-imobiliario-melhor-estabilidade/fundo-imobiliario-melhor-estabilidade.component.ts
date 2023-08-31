import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { DescricaoFundoImobiliarioComponent } from '../descricao-fundo-imobiliario/descricao-fundo-imobiliario.component';
import { DetalheAluguelFundoImobiliarioComponent } from '../detalhe-aluguel-fundo-imobiliario/detalhe-aluguel-fundo-imobiliario.component';
import { FundoImobiliarioApi } from '../shared/sdk';

@Component({
  selector: 'app-fundo-imobiliario-melhor-estabilidade',
  templateUrl: './fundo-imobiliario-melhor-estabilidade.component.html',
  styleUrls: ['./fundo-imobiliario-melhor-estabilidade.component.css']
})
export class FundoImobiliarioMelhorEstabilidadeComponent  extends BaseListComponent  {

 constructor(protected dialog: MatDialog, protected srv: FundoImobiliarioApi) {
    super(dialog, srv);
 }

 getFiltro() {
   return {
     'order' : 'variacao24m asc',
     'limit' : '30',
     'where' : {'and' : [
       {'variacao24m' : {'gt' : 0}},
       {'mediaNegocio3' : {'gt' : 20}},
       {'mediaPercentualAluguel6' : {'gte' : 1.25}}
     ]}
   }
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




