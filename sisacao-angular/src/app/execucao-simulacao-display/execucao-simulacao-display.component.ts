import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ExecucaoSimulacao, ExecucaoSimulacaoApi } from '../shared/sdk';
import { TradeExecucaoSimulacaoComponent } from '../trade-execucao-simulacao/trade-execucao-simulacao.component';

@Component({
  selector: 'app-execucao-simulacao-display',
  templateUrl: './execucao-simulacao-display.component.html',
  styleUrls: ['./execucao-simulacao-display.component.css']
})
export class ExecucaoSimulacaoDisplayComponent implements OnInit {

  @Input() item: ExecucaoSimulacao;

  constructor(private dialog: MatDialog, private srv:ExecucaoSimulacaoApi) { }

  ngOnInit() {
  }

  trades(item) {
    console.log('Clicou trades');
    this.dialog.open(TradeExecucaoSimulacaoComponent, {
      width: '900px',
      data: {
          item: item
      }
    });
  }

  monitorar(item) {
    console.log('Monitorar:' , item);
    item.monitorar = 1;
    this.srv.updateAttributes(item.id,item)
      .subscribe((result) => {
        //this.carregaMelhores();
      })
  }
}
