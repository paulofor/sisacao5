import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';

import { BaseDisplayComponent } from '../base-component/base-display-component';
import { ExperimentoPreRede, ExperimentoPreRedeApi, ExperimentoPreRedeTreinada, PreRedeNeuralApi, VersaoPreRede, VersaoPreRedeApi } from '../shared/sdk';
import { BaseItemComListaComponent } from '../base-component/base-item-com-lista';
import { ActivatedRoute } from '@angular/router';
import { PreRedeVersaoEditComponent } from '../pre-rede-versao-edit/pre-rede-versao-edit.component';
import { CriaExperimentoPreRedeEditComponent } from '../cria-experimento-pre-rede-edit/cria-experimento-pre-rede-edit.component';
import { ExperimentoPreRedeTreinadaEditComponent } from '../experimento-pre-rede-treinada-edit/experimento-pre-rede-treinada-edit.component';

@Component({
  selector: 'app-pre-rede-versao-list',
  templateUrl: './pre-rede-versao-list.component.html',
  styleUrls: ['./pre-rede-versao-list.component.css']
})
export class PreRedeVersaoListComponent extends BaseItemComListaComponent {

  constructor(protected srv:PreRedeNeuralApi, protected router: ActivatedRoute,protected dialog: MatDialog,private srvVersao: VersaoPreRedeApi,
    private srvExperimento: ExperimentoPreRedeApi) { 
    super(srv,router,dialog);
  }  

  getFiltro() {
    return {
      'include' : [
        {
        'relation' : 'versaoPreRedes' , 'scope' : {
          'include' : [
            'versaoPreRedeRegras',
              {'relation' : 'experimentoPreRedes' , 'scope' : {'include' : [
                'amostraDadoSinteticoEntrada1',
                'amostraDadoSinteticoEntrada2',
                {'relation' : 'experimentoPreRedeTreinadas' , 'scope' : {'include' : ['grupoAcao','regraProjecao','periodoTreinoRede']}}
              ]}}
          ]
        }},
        'tipoExemploTreino1',
        'tipoExemploTreino2'
      ]
    }

  }

  calulaResultadoExperimento(experimento:ExperimentoPreRede) {
    console.log('experimento.id:', experimento.id);
    this.srvExperimento.CalculaResultadoTeste(experimento.id)
      .subscribe((result) => {
        this.carregaTela()
      }) 
  }

  geraVersaoRegra(item:VersaoPreRede) {
    this.srvVersao.GerarRedeRegra(item.id)
      .subscribe((result) => {
        this.carregaTela()
      })
  }

  criaRede(idVersao) {
    this.srvVersao.CriaRedeNeural(idVersao)
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  criaExperimentoRedeTreinada(item:ExperimentoPreRede) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(ExperimentoPreRedeTreinadaEditComponent, {
      width: '800px',
      data: {
        origem: item
      }
    });
  }

  editaRedeTreinada(item:ExperimentoPreRedeTreinada) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(ExperimentoPreRedeTreinadaEditComponent, {
      width: '800px',
      data: {
        item: item
      }
    });

  }


  criaExperimento(item:VersaoPreRede) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(CriaExperimentoPreRedeEditComponent, {
      width: '800px',
      data: {
        origem: item
      }
    });

  }


  setListaBase() {
    this.listaBase = this.principal.versaoPreRedes;
  };

  getComponente() {
    return PreRedeVersaoEditComponent;
  }
}
