import { Component, OnInit, Inject } from '@angular/core';
import { AtivoOpcao, AtivoOpcaoApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-ativo-opcao-edita',
  templateUrl: './ativo-opcao-edita.component.html',
  styleUrls: ['./ativo-opcao-edita.component.css']
})
export class AtivoOpcaoEditaComponent implements OnInit {

  
  item: AtivoOpcao;

  constructor(public dialogRef: MatDialogRef<AtivoOpcaoEditaComponent>
    , @Inject(MAT_DIALOG_DATA) public data: any, private servico: AtivoOpcaoApi,
  ) {
  }


  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (!this.data.item) {
      console.log("fluxo nova");
      this.item = new AtivoOpcao();
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
