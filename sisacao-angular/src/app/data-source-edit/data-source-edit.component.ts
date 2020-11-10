import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { DataSource, DataSourceApi } from '../shared/sdk';

@Component({
  selector: 'app-data-source-edit',
  templateUrl: './data-source-edit.component.html',
  styleUrls: ['./data-source-edit.component.css']
})
export class DataSourceEditComponent implements OnInit {

  item: DataSource;

  constructor(public dialog: MatDialogRef<DataSourceEditComponent>, 
      @Inject(MAT_DIALOG_DATA) public data: any, private srv:DataSourceApi) { }

  ngOnInit() {
    if (!this.data.item) {
      this.item = new DataSource();
    } else {
      this.item = this.data.item;
    }
  }

  onSubmit() {
    if (!this.item.id) {
      this.srv.create(this.item, (err, obj) => {
        if (err) console.log('ErroCreate: ', err)
      }).subscribe((r: any) => {
        this.dialog.close()
      })
    } else {
      this.srv.updateAttributes(this.item.id, this.item, (err, obj) => {
        if (err) console.log('ErroUpdate: ', err)
      }).subscribe((r: any) => {
        this.dialog.close()
      })
    }
  }



}
