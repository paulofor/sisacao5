import { Component, OnInit, Inject } from '@angular/core';
import { AtivoAcao, AtivoAcaoApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-ativo-acao-edita',
  templateUrl: './ativo-acao-edita.component.html',
  styleUrls: ['./ativo-acao-edita.component.css']
})
export class AtivoAcaoEditaComponent implements OnInit {

  item: AtivoAcao;

  constructor(public dialogRef: MatDialogRef<AtivoAcaoEditaComponent>
    , @Inject(MAT_DIALOG_DATA) public data: any, private servico: AtivoAcaoApi,
  ) {
  }


  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (!this.data.item) {
      console.log("fluxo nova");
      this.item = new AtivoAcao();
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
