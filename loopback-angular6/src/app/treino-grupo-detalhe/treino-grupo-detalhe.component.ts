import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { TreinoGrupoRedeApi, TreinoGrupoRede, TreinoRedeApi, RegraProjecao, RegraProjecaoApi, GrupoRegraRelApi } from '../shared/sdk';
import { TreinoGrupoEditaComponent } from '../treino-grupo-edita/treino-grupo-edita.component';
import { TreinoRedeGrupoEditaComponent } from '../treino-rede-grupo-edita/treino-rede-grupo-edita.component';

@Component({
  selector: 'app-treino-grupo-detalhe',
  templateUrl: './treino-grupo-detalhe.component.html',
  styleUrls: ['./treino-grupo-detalhe.component.css']
})
export class TreinoGrupoDetalheComponent  extends BaseListComponent {

  treinoGrupoRede : TreinoGrupoRede;
  listaRegra : RegraProjecao[];

  constructor(protected dialog: MatDialog, protected srv:TreinoGrupoRedeApi,public router: ActivatedRoute, 
      private srvTreino:TreinoRedeApi, private srvRegra : GrupoRegraRelApi, private srvRegraProjecao: RegraProjecaoApi) { 
    super(dialog,srv)
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

  atualizaRegra(idRegra) {
    this.srvRegraProjecao.AtualizaTotais(idRegra)
      .subscribe((result) => {
        this.carregaTela();
      })
  } 
  atualizaDatas() {
    this.srv.AtualizaTemData(this.treinoGrupoRede.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  precisaTreino(itemRegra,item) {
    console.log('itemRegra:' , itemRegra);
    console.log('item', item);
    if (itemRegra.regraProjecao.ultimaInsercao && !item.dataTreinamento) return "dgc-alerta"
    else return ""
  }

  classeAtivo(item) {
    if (item.ativoPrevisao==1) return "dgc-treino-previsao"
    else return "";
  }
  pendente(ativo) {
    if (ativo==1) return "dgc-pendente";
    else return "";
  }

  ativaTeste(item) {
    console.log('item' , item);
    this.srvTreino.AlteraAtivaTeste(item.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }
  ativaPrevisaoTeste(item) {
    console.log('item' , item);
    this.srvTreino.AlteraAtivaPrevisaoTeste(item.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  resetTeste() {
    this.srvTreino.DesligaTesteGrupo(this.treinoGrupoRede.id)
      .subscribe((result) => {
        this.carregaTela();
      })
  }
  criaTreino() {
    this.srv.CriaTreino(this.treinoGrupoRede.id)
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
            'include' : ['redeNeural' , 'regraProjecao'],
            'where' : {'treinoRedeGrupoId' : id }
          }
        }, 'grupoAcao' ,'periodoTreinoRede'
        ]
      }
      this.srv.findById(id, filtro)
        .subscribe((result: TreinoGrupoRede) => {
          console.log('treinoGrupoRede', result);
          this.treinoGrupoRede = result;
          //this.listaBase = this.treinoGrupoRede.treinoRedes;
          this.carregaRegra(result);
        })
    })
  }

  carregaRegra(treinoGrupo:TreinoGrupoRede) {
    let filtro = {
      'where' : {'grupoRegraId' : treinoGrupo.grupoRegraId} ,
      'include' : 
        {
          'relation' : 'regraProjecao' , 
          'scope' : { 'include' : {
            'relation' : 'treinoRedes' ,
            'scope' : { 
              'include' : {'relation' : 'redeNeural'},
              'where' : {'treinoGrupoRedeId' : treinoGrupo.id }
            }, 'where' : {'treinoGrupoRedeId' : treinoGrupo.id }
          }}
        }
    }
    this.srvRegra.find(filtro)
      .subscribe((result) => {
        console.log('Carrega Regra: ' , result);
        this.listaBase = result;
      })
  }
 
  getComponente() {
    return TreinoRedeGrupoEditaComponent;
  }
}
