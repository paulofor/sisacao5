import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DataSourceEditComponent } from '../data-source-edit/data-source-edit.component';
import { DataSource, DataSourceApi } from '../shared/sdk';

@Component({
  selector: 'app-data-source-list',
  templateUrl: './data-source-list.component.html',
  styleUrls: ['./data-source-list.component.css']
})
export class DataSourceListComponent implements OnInit {

  lista: DataSource[];

  constructor(private srv: DataSourceApi, private dialog : MatDialog) { }

  ngOnInit() {
    this.carregaLista();
  }

  carregaLista() {
    this.srv.find()
      .subscribe((result:DataSource[]) => {
        this.lista = result;
      })
  }

  novo(edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaLista();
    });
    this.dialog.open(DataSourceEditComponent, {
      width: '800px',
      data: {
        item: edicao
      }
    });
  }

}
