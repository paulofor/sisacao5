import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { DescricaoFundoImobiliarioComponent } from '../descricao-fundo-imobiliario/descricao-fundo-imobiliario.component';
import { AluguelFundoImobiliario, AluguelFundoImobiliarioApi, FundoImobiliario, FundoImobiliarioApi } from '../shared/sdk';

@Component({
  selector: 'app-detalhe-aluguel-fundo-imobiliario',
  templateUrl: './detalhe-aluguel-fundo-imobiliario.component.html',
  styleUrls: ['./detalhe-aluguel-fundo-imobiliario.component.css']
})
export class DetalheAluguelFundoImobiliarioComponent implements OnInit {
  lista: AluguelFundoImobiliario[];
  item : FundoImobiliario;


  constructor(public dialogRef: MatDialogRef<DetalheAluguelFundoImobiliarioComponent>
    , @Inject(MAT_DIALOG_DATA) public data: any, private srv: AluguelFundoImobiliarioApi) {
  }

  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (this.data.item) {
      this.item = this.data.item;
      let filtro = {
        'where' : {'ticker' : this.item.ticker},
        'order' : 'dataPagamento desc',
        'limit' : 36

      }
      this.srv.find(filtro)
        .subscribe((lista:AluguelFundoImobiliario[]) => {
          this.lista = lista;
          console.log('Lista: ' , this.lista);
        })
    }
  }

}
