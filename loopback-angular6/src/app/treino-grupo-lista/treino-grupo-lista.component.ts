import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
;

import { TreinoGrupoEditaComponent } from '../treino-grupo-edita/treino-grupo-edita.component';
import { PeriodoTreinoRedeApi, TreinoGrupoRedeApi } from '../shared/sdk';
import { TreinoGrupoRede } from '../shared/sdk/models/TreinoGrupoRede';


@Component({
  selector: 'app-treino-grupo-lista',
  templateUrl: './treino-grupo-lista.component.html',
  styleUrls: ['./treino-grupo-lista.component.css']
})
export class TreinoGrupoListaComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:TreinoGrupoRedeApi,public router: Router, private srvPeriodo:PeriodoTreinoRedeApi) { 
    super(dialog,srv)
  }

  criaItem() {
    return new TreinoGrupoRede();
  }

  getComponente() {
    return TreinoGrupoEditaComponent;
  }



  carregaTela() {
    const filtro = {
      'order' : 'diaNumInicioExecucao desc',
      'include' : {'relation' : 'treinoGrupoRedes' , 'scope' : {
        'include' : [
          { 'relation': 'grupoRede' , 'scope' : {
            'include' : { 'relation' : 'grupoRedeRels' , 'scope' : {'include' : 'redeNeural'}}
          }},
          'grupoAcao',
          'grupoRegra'
        ]
      }}
    }
    this.srvPeriodo.find(filtro)
    .subscribe((result:any[]) => {
        console.log('result: ' , result);
        this.listaBase = result;
        this.posCarregaLista();
    })
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

  listaRedes(item:TreinoGrupoRede) {
    let saida = ''
    for (let i=0;i<item.grupoRede.grupoRedeRels.length;i++) {
      if (i!=0) saida += ", " + item.grupoRede.grupoRedeRels[i].redeNeural.nome;
      else saida = item.grupoRede.grupoRedeRels[i].redeNeural.nome;
    }
    return saida;

  }

  getFiltro() {
    return {
      'order' : 'grupoRedeId',
      'include' : [
        { 'relation': 'grupoRede' , 'scope' : {
          'include' : { 'relation' : 'grupoRedeRels' , 'scope' : {'include' : 'redeNeural'}}
        }},
        'grupoAcao',
        'periodoTreinoRede',
        'grupoRegra'
      ]
    };
  }  
}
