import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { PrevisaoRede } from '../shared/sdk';
import { TradeNovoSimulacaoComponent } from '../trade-novo-simulacao/trade-novo-simulacao.component';
import { TradeRealListaEditComponent } from '../trade-real-lista-edit/trade-real-lista-edit.component';

@Component({
  selector: 'app-previsao-rede-item-dia',
  templateUrl: './previsao-rede-item-dia.component.html',
  styleUrls: ['./previsao-rede-item-dia.component.css']
})
export class PrevisaoRedeItemDiaComponent implements OnInit {


  listaPrevisao: any[]
  @Input() rede: any;
  
  constructor(protected dialog: MatDialog) { }

  ngOnInit() {
    this.listaPrevisao = this.rede.previsaoRedes
  }

 


 

  telaCompra(item:PrevisaoRede) {
    this.dialog.open(TradeNovoSimulacaoComponent, {
      width: '900px',
      data: {
          origem: item
      }
    });
  }
}
