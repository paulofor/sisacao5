import { Component, OnInit, Inject } from '@angular/core';
import { AtivoImobiliario, AtivoImobiliarioApi } from '../shared/sdk';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-ativo-imobiliario-edita',
  templateUrl: './ativo-imobiliario-edita.component.html',
  styleUrls: ['./ativo-imobiliario-edita.component.css']
})
export class AtivoImobiliarioEditaComponent implements OnInit {

 
  item: AtivoImobiliario;

  constructor(public dialogRef: MatDialogRef<AtivoImobiliarioEditaComponent>
    , @Inject(MAT_DIALOG_DATA) public data: any, private servico: AtivoImobiliarioApi,
  ) {
  }


  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (!this.data.item) {
      console.log("fluxo nova");
      this.item = new AtivoImobiliario();
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
