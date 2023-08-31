import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { PreRedeNeuralApi, PreRedeNeural, TipoExemploTreinoApi, TipoExemploTreino, PeriodoTreinoRedeApi, GrupoAcaoApi, RegraProjecaoApi, GrupoAcao, PeriodoTreinoRede, RegraProjecao } from '../shared/sdk';

@Component({
  selector: 'app-pre-rede-edit',
  templateUrl: './pre-rede-edit.component.html',
  styleUrls: ['./pre-rede-edit.component.css']
})
export class PreRedeEditComponent extends BaseEditComponent {

  listaTipoExemplo:TipoExemploTreino[];
  listaPeriodo:PeriodoTreinoRede[];
  listaGrupoAcao:GrupoAcao[];
  listaRegraCompra:RegraProjecao[];
  listaRegraVenda:RegraProjecao[];

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: PreRedeNeuralApi, private srvTipoExemplo:TipoExemploTreinoApi,
    private srvPeriodo:PeriodoTreinoRedeApi, private srvGrupoAcao:GrupoAcaoApi, private srvRegra:RegraProjecaoApi
  ) {
    super(dialogRef,data,servico);
  }

  montaCombos() {
    this.srvPeriodo.find()
      .subscribe((result:PeriodoTreinoRede[]) => {
        this.listaPeriodo = result;
      })
    this.srvGrupoAcao.find() 
      .subscribe((result:GrupoAcao[]) => {
        this.listaGrupoAcao = result;
      })
    let filtroCompra = {'order' : 'codigoRegraProjecao', 'where' : {'tipoCompraVenda' : 'C'}};
    let filtroVenda = {'order' : 'codigoRegraProjecao', 'where' : {'tipoCompraVenda' : 'V'}};
    this.srvRegra.find(filtroCompra)
      .subscribe((result:RegraProjecao[]) => {
        this.listaRegraCompra = result;
      })
    this.srvRegra.find(filtroVenda)
      .subscribe((result:RegraProjecao[]) => {
        this.listaRegraVenda = result;
      })
    this.srvTipoExemplo.find()
      .subscribe((result:TipoExemploTreino[])=> {
        console.log('TipoExemplo' , result);
        this.listaTipoExemplo = result;
      })
  }

  preSubmit() {
    console.log('item:' , this.item);
    delete this.item['versaoPreRedes'];
    delete this.item['tipoExemploTreino1'];
    delete this.item['tipoExemploTreino2'];
    delete this.item['periodoTreinoRede'];
    delete this.item['grupoAcao'];

    delete this.item['regraProjecaoVenda1'];
    delete this.item['regraProjecaoVenda2'];
    delete this.item['regraProjecaoVenda3'];
    delete this.item['regraProjecaoCompra1'];
    delete this.item['regraProjecaoCompra2'];
    delete this.item['regraProjecaoCompra3'];

  }

  criaItem() {
    return new PreRedeNeural();
  }

}
