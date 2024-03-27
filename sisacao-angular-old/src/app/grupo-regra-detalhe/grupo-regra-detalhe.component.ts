import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RegraProjecaoEditComponent } from '../regra-projecao-edit/regra-projecao-edit.component';
import { RegraProjecaoApi, RegraProjecao, AtivoAcao, PeriodoExperimento, GrupoRegraApi, ExemploTreinoAcaoSaidaApi } from '../shared/sdk';

@Component({
  selector: 'app-grupo-regra-detalhe',
  templateUrl: './grupo-regra-detalhe.component.html',
  styleUrls: ['./grupo-regra-detalhe.component.css']
})
export class GrupoRegraDetalheComponent extends BaseListComponent {

  processando = false;

  constructor(protected dialog: MatDialog, protected srv:ExemploTreinoAcaoSaidaApi,public router: Router,  private routerAtivo: ActivatedRoute,) { 
    super(dialog,srv)
  }

  percentualClasse0(item) {
    return (item.classe0 / item.qtdeSaida) * 100;
  }
  percentualClasse1(item) {
    return (item.classe1 / item.qtdeSaida) * 100;
  }
  percentualResultado(item) {
    return (item.resultado / item.qtdeSaida) * 100;
  }

  atualiza() {
    this.carregaTela();
  }

 


  carregaTela() {
    this.processando = true;
    let filtro = {'include' : {'relation' : 'grupoRegraRels' , 'scope' : {
      'include' : 'regraProjecao'
    }}}
    this.routerAtivo.params.subscribe((params) => {
      let idGrupo = params['id'];
      this.srv.ResumoPorRegraGrupo(idGrupo)
      .subscribe((result:any[]) => {
          console.log('result: ' , result);
          this.listaBase = result;
          this.processando = false;
          this.posCarregaLista();
      })
    })
    
  }


}
