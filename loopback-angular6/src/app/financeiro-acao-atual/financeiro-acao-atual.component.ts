import { Component, OnInit } from '@angular/core';
import { FinanceiroAcaoDia, FinanceiroAcaoDiaApi, FinanceiroAcaoFixo, FinanceiroAcaoFixoApi } from '../shared/sdk';
import { FinanceiroFixoAcaoEditComponent } from '../financeiro-fixo-acao-edit/financeiro-fixo-acao-edit.component';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-financeiro-acao-atual',
  templateUrl: './financeiro-acao-atual.component.html',
  styleUrls: ['./financeiro-acao-atual.component.css']
})
export class FinanceiroAcaoAtualComponent implements OnInit {

  financeiroDia : FinanceiroAcaoDia
  financeiroFixo : FinanceiroAcaoFixo;

  constructor(protected dialog: MatDialog, private srvFinanceiroDia: FinanceiroAcaoDiaApi, 
      private srvFinanceiroFixo: FinanceiroAcaoFixoApi) { }

  ngOnInit() {
    this.carregaTela();
  }

  converteData(diaent) {
    //  AAAAMMDD
    //  01234567
    let dataNum = String(diaent);
    let ano = dataNum.substring(0,4);
    let mes = dataNum.substring(4,6);
    let dia = dataNum.substring(6);
    return dia + '/' + mes + '/' + ano;
  }

  carregaTela() {
    this.carregaFinanceiroDia();
    this.carregaFinanceiroFixo();
  }

  carregaFinanceiroFixo() {
    let filtro = {'order' : 'dataAlteracao desc' , 'limit' : 1};
    this.srvFinanceiroFixo.findOne(filtro)
      .subscribe((result:FinanceiroAcaoFixo) => {
        console.log('Financeiro Fixo:' , result);
        this.financeiroFixo = result;
      })
  }


  alteraFixoAtual() {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(FinanceiroFixoAcaoEditComponent, {
      width: '800px',
      data: {
      }
    });
  }


  carregaFinanceiroDia() {
    let filtro = {
      'order' : 'diaNum desc',
      'limit' : 1
    }
    this.srvFinanceiroDia.findOne(filtro)
      .subscribe((resultado:FinanceiroAcaoDia) => {
        console.log('FinanceiroAcaoDia:' , resultado);
        this.financeiroDia = resultado;
      })
  }

}
