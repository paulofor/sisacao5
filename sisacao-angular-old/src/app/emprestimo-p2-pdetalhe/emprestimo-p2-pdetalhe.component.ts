import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router, ActivatedRoute } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { ParcelaEmprestimoEditComponent } from '../parcela-emprestimo-edit/parcela-emprestimo-edit.component';
import { EmprestimoP2P, EmprestimoP2PApi } from '../shared/sdk';

@Component({
  selector: 'app-emprestimo-p2-pdetalhe',
  templateUrl: './emprestimo-p2-pdetalhe.component.html',
  styleUrls: ['./emprestimo-p2-pdetalhe.component.css']
})
export class EmprestimoP2PDetalheComponent extends BaseListComponent{


  emprestimo: EmprestimoP2P;


  constructor(protected dialog: MatDialog, protected srv:EmprestimoP2PApi, private router: ActivatedRoute) { 
    super(dialog,srv)
  }

  criaParcela() {
    this.srv.CriaParcelas(this.emprestimo.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }


  getComponente() {
    return ParcelaEmprestimoEditComponent;

  }



  carregaTela() {
    this.router.params.subscribe((params) => {
      let id = params['id'];
      let filtro = {
        'include':
        {
          'relation': 'parcelaEmprestimos', 'scope': { 'order': 'numeroParcela' }
        }
      }
      this.srv.findById(id, filtro)
        .subscribe((result: EmprestimoP2P) => {
          console.log('emprestimo', result);
          this.emprestimo = result;
          this.listaBase = this.emprestimo.parcelaEmprestimos;
        })
    })
  }

}
