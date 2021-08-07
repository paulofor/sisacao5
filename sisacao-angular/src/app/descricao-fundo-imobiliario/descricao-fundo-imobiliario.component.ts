import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FundoImobiliario, FundoImobiliarioApi } from '../shared/sdk';

@Component({
  selector: 'app-descricao-fundo-imobiliario',
  templateUrl: './descricao-fundo-imobiliario.component.html',
  styleUrls: ['./descricao-fundo-imobiliario.component.css']
})
export class DescricaoFundoImobiliarioComponent implements OnInit {

  item: FundoImobiliario;


  constructor(public dialogRef: MatDialogRef<DescricaoFundoImobiliarioComponent>
    , @Inject(MAT_DIALOG_DATA) public data: any, private srv: FundoImobiliarioApi) {
  }

  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (this.data.item) {
      this.item = this.data.item;
      
    }
  }



}
