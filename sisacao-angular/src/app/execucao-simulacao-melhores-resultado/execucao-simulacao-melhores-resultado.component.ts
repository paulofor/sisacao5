import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ExecucaoSimulacao, ExecucaoSimulacaoApi } from '../shared/sdk';
import { TradeExecucaoSimulacaoComponent } from '../trade-execucao-simulacao/trade-execucao-simulacao.component';

@Component({
  selector: 'app-execucao-simulacao-melhores-resultado',
  templateUrl: './execucao-simulacao-melhores-resultado.component.html',
  styleUrls: ['./execucao-simulacao-melhores-resultado.component.css']
})
export class ExecucaoSimulacaoMelhoresResultadoComponent implements OnInit {

  listaMelhores: ExecucaoSimulacao[];

  constructor(private dialog: MatDialog, private srv:ExecucaoSimulacaoApi) { }

  ngOnInit() {
    this.carregaMelhores();
  }

  carregaMelhores() {
    let filtro = {
      'order' : ['resultado desc','ticker asc'],
      'limit' : 140,
      'include' : {'relation' : 'combinacaoParametro' , 'scope' : {'include' : 'regraSimulacao'}}
    }
    this.srv.find(filtro)
      .subscribe((result:ExecucaoSimulacao[]) => {
        console.log('Lista:', result);
        this.listaMelhores = result;
      })
  }

 

}
