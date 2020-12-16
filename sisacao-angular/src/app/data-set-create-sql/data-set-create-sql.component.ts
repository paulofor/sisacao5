import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { DataSet } from '../shared/sdk';

@Component({
  selector: 'app-data-set-create-sql',
  templateUrl: './data-set-create-sql.component.html',
  styleUrls: ['./data-set-create-sql.component.css']
})
export class DataSetCreateSqlComponent implements OnInit {


  origem : DataSet;
  sql: string;

  constructor(protected dialogRef: MatDialogRef<any> , @Inject(MAT_DIALOG_DATA) protected data: any) {
  }


  ngOnInit() {
    console.log("Parametro entrada", this.data);
    if (this.data.origem) {
      this.origem = this.data.origem;
      this.montaSql();
    }
   
  }

  montaSql() {
    this.sql = 'CREATE TABLE  ' + this.origem.nome;
    for (let i=1; i <= this.origem.quantidadeInput; i++) {
      this.sql += ' entrada' + i + ' decimal(3,10) ,\n' 
    }
    console.log('SQL-Create: ' , this.sql);
  }

}
