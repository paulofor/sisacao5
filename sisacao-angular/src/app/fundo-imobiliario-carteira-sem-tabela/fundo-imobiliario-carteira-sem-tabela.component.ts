import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { FundoImobilarioCarteiraEditComponent } from '../fundo-imobilario-carteira-edit/fundo-imobilario-carteira-edit.component';
import { FundoImobiliarioCarteiraApi } from '../shared/sdk';

@Component({
  selector: 'app-fundo-imobiliario-carteira-sem-tabela',
  templateUrl: './fundo-imobiliario-carteira-sem-tabela.component.html',
  styleUrls: ['./fundo-imobiliario-carteira-sem-tabela.component.css']
})
export class FundoImobiliarioCarteiraSemTabelaComponent extends BaseListComponent {

  resultadoMes: number;
  proventoMes: number;

  constructor(protected dialog: MatDialog, protected srv:FundoImobiliarioCarteiraApi) { 
    super(dialog,srv);
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
