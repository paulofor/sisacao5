import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { AtivoIndice, AtivoIndiceApi } from '../shared/sdk';

@Component({
  selector: 'app-ativo-indice-edita',
  templateUrl: './ativo-indice-edita.component.html',
  styleUrls: ['./ativo-indice-edita.component.css']
})
export class AtivoIndiceEditaComponent implements OnInit {

 
  item: AtivoIndice;

  constructor(public dialogRef: MatDialogRef<AtivoIndiceEditaComponent>
    , @Inject(MAT_DIALOG_DATA) public data: any, private servico: AtivoIndiceApi,
  ) {
  }


  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (!this.data.item) {
      console.log("fluxo nova");
      this.item = new AtivoIndice();
      this.item.intraday15 = 0;
      this.item.intraday30 = 0;
      this.item.intraday5 = 0;
      this.item.intraday10 = 1;
    } else {
      console.log('fluxo altera');
      this.item = this.data.item;
      console.log('Item:', JSON.stringify(this.item));
    }
  }

  onSubmit() {
    console.log('Model: ' + JSON.stringify(this.item));
    this.servico.upsert(this.item, (err, obj) => {
      console.log("Erro:" + err.message);
    }).subscribe((e: any) => {
      console.log(JSON.stringify(e));
      this.closeDialog();
    });

  }

  closeDialog() {
    this.dialogRef.close('Pizza!');
  }

}
