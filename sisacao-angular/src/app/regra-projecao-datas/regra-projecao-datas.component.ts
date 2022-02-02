import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { GrupoParaAcaoComponent } from '../grupo-para-acao/grupo-para-acao.component';
import { CotacaoIntradayAcaoResultadoValorApi } from '../shared/sdk';

@Component({
  selector: 'app-regra-projecao-datas',
  templateUrl: './regra-projecao-datas.component.html',
  styleUrls: ['./regra-projecao-datas.component.css']
})
export class RegraProjecaoDatasComponent extends BaseListComponent  {

  constructor(private router: ActivatedRoute,protected dialog: MatDialog, protected srv:CotacaoIntradayAcaoResultadoValorApi) {
    super(dialog, srv);
  }


  carregaTela() {
    this.srv.ObtemDatasPorGrupo('Neg-100')
      .subscribe((result:any[]) => {
         console.log('result: ' , result);
         this.listaBase = result;
      })
  }

  grupos(item) {
    let saida = '';
    for (let i=0;i<item.relGrupoAcaos.length;i++) {
      if (i>0) saida += ', '
      saida += item.relGrupoAcaos[i].grupoAcao.nome;
    }
    return saida;
  }
  getDialogo1() : any {
    return GrupoParaAcaoComponent;
  }

}
