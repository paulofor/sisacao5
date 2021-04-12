import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { OrdemCompra, OrdemCompraApi } from '../shared/sdk';

@Component({
  selector: 'app-ordem-compra-edita',
  templateUrl: './ordem-compra-edita.component.html',
  styleUrls: ['./ordem-compra-edita.component.css']
})
export class OrdemCompraEditaComponent extends BaseEditComponent {

  exposicao:number;
  exposicaoNova:number;
  lucro:number;
  totalOrdem:number;
  lucroOperacao: number;

  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: OrdemCompraApi,
  ) {
    super(dialogRef, data, servico);
  }

  criaItem() {
    let item:OrdemCompra = new OrdemCompra();
    item.quantidade = 100;
    item.execucaoSimulacaoId = this.origem.id;
    item.ticker = this.origem.ticker;
    if (this.origem.valorMonitorias.length > 0) {
      item['precoStop'] = this.origem.valorMonitorias[1].valorStop;
      item['precoTarget'] = this.origem.valorMonitorias[1].valorTarget;
    }
    return item;
  }

  posItem() {
    this.carregaExposicaoLucro();
  }

  carregaExposicaoLucro() {
    this.servico.TotalExposicaoLucroGeral()
      .subscribe((resultado) => {
        this.exposicao = resultado.exposicao;
        this.exposicaoNova = resultado.exposicao;
        this.lucro = resultado.lucro;
        this.lucroOperacao = 0;
      })
  }

  calculaExposicao() {
    let prejuizoUnitario = this.item.precoEntrada - this.item.precoStop;
    let totalOrdem = prejuizoUnitario * this.item.quantidade;
    this.exposicaoNova = this.exposicao + totalOrdem + 11;
    let lucroUnitario = this.item.precoTarget - this.item.precoEntrada;
    totalOrdem = lucroUnitario * this.item.quantidade;
    this.lucroOperacao = totalOrdem - 11;
  }

}
