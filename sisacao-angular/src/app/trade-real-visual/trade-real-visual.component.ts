import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TradeRealApi, CotacaoIntradayAcaoApi } from '../shared/sdk';

@Component({
  selector: 'app-trade-real-visual',
  templateUrl: './trade-real-visual.component.html',
  styleUrls: ['./trade-real-visual.component.css']
})
export class TradeRealVisualComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TradeRealApi, private srvCotacao: CotacaoIntradayAcaoApi) { 
    super(dialog,srv);
  }


  getFiltro() {
    return {
      'where' : {'posicaoAtual' : {'neq' : 0}},
      'order' : 'dataEntrada desc',
      'include' : [
          {'relation' : 'execucaoSimulacao'},
          {'relation' : 'ativoAcao' }
      ]
    }
  }
}
