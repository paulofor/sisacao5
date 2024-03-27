import { Component, OnInit, Inject } from '@angular/core';
import { AtivoMercadoria, AtivoMercadoriaApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-ativo-mercadoria-edita',
  templateUrl: './ativo-mercadoria-edita.component.html',
  styleUrls: ['./ativo-mercadoria-edita.component.css']
})
export class AtivoMercadoriaEditaComponent implements OnInit {

 
  item: AtivoMercadoria;

  constructor(public dialogRef: MatDialogRef<AtivoMercadoriaEditaComponent>
    , @Inject(MAT_DIALOG_DATA) public data: any, private servico: AtivoMercadoriaApi,
  ) {
  }


  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (!this.data.item) {
      console.log("fluxo nova");
      this.item = new AtivoMercadoria();
      this.item.intraday15 = 0;
      this.item.intraday30 = 0;
      this.item.intraday5 = 0;
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
