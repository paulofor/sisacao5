import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { TreinoGrupoRedeApi, TreinoGrupoRede, TreinoRedeApi } from '../shared/sdk';
import { TreinoGrupoEditaComponent } from '../treino-grupo-edita/treino-grupo-edita.component';

@Component({
  selector: 'app-treino-grupo-detalhe',
  templateUrl: './treino-grupo-detalhe.component.html',
  styleUrls: ['./treino-grupo-detalhe.component.css']
})
export class TreinoGrupoDetalheComponent  extends BaseListComponent {

  treinoGrupoRede : TreinoGrupoRede;

  constructor(protected dialog: MatDialog, protected srv:TreinoGrupoRedeApi,public router: ActivatedRoute, 
      private srvTreino:TreinoRedeApi) { 
    super(dialog,srv)
  }

  ativaTeste(item) {
    console.log('item' , item);
    this.srvTreino.AtivaTeste(item.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }
 
  carregaTela() {
    this.router.params.subscribe((params) => {
      let id = params['id'];
      let filtro = {
        'include':
        [{
          'relation': 'treinoRedes', 'scope': { 
            'order': 'id',
            'include' : ['redeNeural' , 'regraProjecao']
          }
        }, 'grupoAcao' ,'periodoTreinoRede'
        ]
      }
      this.srv.findById(id, filtro)
        .subscribe((result: TreinoGrupoRede) => {
          console.log('treinoGrupoRede', result);
          this.treinoGrupoRede = result;
          this.listaBase = this.treinoGrupoRede.treinoRedes;
        })
    })
  }
 
}
