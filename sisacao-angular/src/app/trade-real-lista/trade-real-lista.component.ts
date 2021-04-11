import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TradeRealApi } from '../shared/sdk';
import { TradeRealListaEditComponent } from '../trade-real-lista-edit/trade-real-lista-edit.component';

@Component({
  selector: 'app-trade-real-lista',
  templateUrl: './trade-real-lista.component.html',
  styleUrls: ['./trade-real-lista.component.css']
})
export class TradeRealListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TradeRealApi) { 
    super(dialog,srv);
  }

  getComponente() {
    return TradeRealListaEditComponent;
  }
 
  calcular(item) {
   
  }

}
