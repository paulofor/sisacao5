import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { FundoImobilarioCarteiraEditComponent } from '../fundo-imobilario-carteira-edit/fundo-imobilario-carteira-edit.component';
import { FundoImobiliarioCarteiraApi } from '../shared/sdk';


@Component({
  selector: 'app-fundo-imobiliario-carteira',
  templateUrl: './fundo-imobiliario-carteira.component.html',
  styleUrls: ['./fundo-imobiliario-carteira.component.css']
})
export class FundoImobiliarioCarteiraComponent extends BaseListComponent {

  resultadoMes: number;
  proventoMes: number;

  constructor(protected dialog: MatDialog, protected srv:FundoImobiliarioCarteiraApi) { 
    super(dialog,srv);
  }

  getFiltro() {
    const now = new Date();
    let data = new Date(now.getFullYear(), now.getMonth(), 1);
    let dataStr = data.toISOString().split('T')[0]
    let filtro = {'where' : {'dataReferencia' : dataStr }};
    console.log('filtro:' , filtro);
    return filtro;
  }

  getComponente() {
    return FundoImobilarioCarteiraEditComponent;
  }

  posCarregaLista(): void {
      this.resultadoMes = 0;
      this.proventoMes = 0;
      this.listaBase.forEach((item) => {
        console.log('item:' ,  item);
        if (item.valorizacaoAtual>-1000) {
          this.resultadoMes += item.valorizacaoAtual;
        };
        if (item.proventoTotal!=null)
          this.proventoMes += item.proventoTotal;
      })
  }

}
