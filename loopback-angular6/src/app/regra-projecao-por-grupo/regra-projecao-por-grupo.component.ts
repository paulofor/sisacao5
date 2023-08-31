import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseItemComListaComponent } from '../base-component/base-item-com-lista';
import { RegraProjecaoEditComponent } from '../regra-projecao-edit/regra-projecao-edit.component';
import { GrupoRegraApi, RegraProjecao, RegraProjecaoApi } from '../shared/sdk';

@Component({
  selector: 'app-regra-projecao-por-grupo',
  templateUrl: './regra-projecao-por-grupo.component.html',
  styleUrls: ['./regra-projecao-por-grupo.component.css']
})
export class RegraProjecaoPorGrupoComponent extends BaseItemComListaComponent {

  constructor(protected dialog: MatDialog,protected srv:GrupoRegraApi, protected router: ActivatedRoute, protected srvRegra:RegraProjecaoApi) {
    super(srv,router, dialog);
  }

  setListaBase() {
    this.srvRegra.ListaPorGrupoRegra(this.principal.id)
      .subscribe((result:RegraProjecao[]) => {
        this.listaBase = result;
      })
  };

  getComponente() {
    return RegraProjecaoEditComponent;
  }

  zeraPrioridadeGrupo(item:RegraProjecao) {
    this.srvRegra.ZerarPrioridadePorGrupo(item.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  edita(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
        this.carregaTela();
    });
    this.dialog.open(this.getComponente(), {
        width: '800px',
        data: {
            item: edicao
        }
    });
}

}
