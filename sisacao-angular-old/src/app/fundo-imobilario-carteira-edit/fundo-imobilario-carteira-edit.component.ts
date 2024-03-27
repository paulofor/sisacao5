import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { FundoImobiliarioCarteira, FundoImobiliarioCarteiraApi } from '../shared/sdk';

@Component({
  selector: 'app-fundo-imobilario-carteira-edit',
  templateUrl: './fundo-imobilario-carteira-edit.component.html',
  styleUrls: ['./fundo-imobilario-carteira-edit.component.css']
})
export class FundoImobilarioCarteiraEditComponent  extends BaseEditComponent {

  
  constructor(protected dialogRef: MatDialogRef<any>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: FundoImobiliarioCarteiraApi) 
  {
    super(dialogRef,data,servico);
  }


  criaItem() {
    return new FundoImobiliarioCarteira();
  }

  

}
