import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { ParcelaEmprestimoEditComponent } from '../parcela-emprestimo-edit/parcela-emprestimo-edit.component';
import { ParcelaEmprestimoApi } from '../shared/sdk';

@Component({
  selector: 'app-emprestimo-p2-pmes-corrente',
  templateUrl: './emprestimo-p2-pmes-corrente.component.html',
  styleUrls: ['./emprestimo-p2-pmes-corrente.component.css']
})
export class EmprestimoP2PMesCorrenteComponent extends BaseListComponent{


  totalPrevisto:number;
  totalPago:number;
  qtdePago:number;

  firstDay: Date;
  lastDay:Date;

  constructor(protected dialog: MatDialog, protected srv:ParcelaEmprestimoApi, private router: ActivatedRoute) { 
    super(dialog,srv);
    const now = new Date();

    this.firstDay = new Date(now.getFullYear(), now.getMonth(), 1);
    //console.log(firstDay); // 👉️ Sat Oct 01 2022 ...

    this.lastDay = new Date(now.getFullYear(), now.getMonth() + 1, 0);
    //console.log(lastDay);
  }

  posCarregaLista() {
    this.totalPrevisto = 0;
    this.totalPago = 0;
    this.qtdePago = 0;
    this.listaBase.forEach((item) => {
      this.totalPrevisto += item.valorPrevisto;
      this.totalPago += item.valorRecebido;
      if (item.valorRecebido > 0) this.qtdePago++;
    })
  }

  getComponente() {
    return ParcelaEmprestimoEditComponent;

  }

  getFiltro() {
    return {
      'include' : 'emprestimoP2P',
      'order' : 'dataVencimento',
      'where' : { 'and' : [
          {'dataVencimento' : {'gte' : this.firstDay}},
          {'dataVencimento' : {'lte'  : this.lastDay}}
        ]}
    }
  }


  
}
