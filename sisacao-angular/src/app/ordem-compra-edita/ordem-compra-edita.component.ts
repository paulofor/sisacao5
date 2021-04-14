import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { CUSTO_TRADE } from '../constantes/base.url';
import { OrdemCompra, OrdemCompraApi } from '../shared/sdk';

@Component({
  selector: 'app-ordem-compra-edita',
  templateUrl: './ordem-compra-edita.component.html',
  styleUrls: ['./ordem-compra-edita.component.css']
})
export class OrdemCompraEditaComponent extends BaseEditComponent {

  exposicao:number;
  exposicaoNova:number;
  exposicaoOperacao:number;
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
    if (this.origem.valorMonitorias.length > 1) {
      if (this.origem.valorMonitorias[1].posicao==1) {
        item['precoStop'] = this.origem.valorMonitorias[1].valorStop;
        item['precoTarget'] = this.origem.valorMonitorias[1].valorTarget;
        item['precoCompra'] =  this.origem.valorMonitorias[1].valorEntrada;
      } else {
        item['precoStop'] = this.origem.pontoSaidaPrejuizo;
        item['precoTarget'] = this.origem.pontoSaidaLucro;
        item['precoCompra'] = this.origem.precoEntrada;
      }
    }
    return item;
  }

  posItem() {
    this.carregaExposicaoLucro();
  }

  preSubmit() {
    this.item.valorExposicao = this.exposicaoOperacao;
    this.item.aberta = 1;
    this.item.lucroAlvo = this.lucroOperacao;
    if (this.item.quantidade < 100) {
      this.item.fracionario = 1
    } else {
      this.item.fracionario = 0;
    }
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
    let prejuizoUnitario = this.item.precoCompra - this.item.precoStop;
    this.exposicaoOperacao = (prejuizoUnitario * this.item.quantidade) + CUSTO_TRADE;
    this.exposicaoNova = this.exposicao + this.exposicaoOperacao;
    let lucroUnitario = this.item.precoTarget - this.item.precoCompra;
    let totalOrdem = lucroUnitario * this.item.quantidade;
    this.lucroOperacao = totalOrdem - CUSTO_TRADE;
  }

}
