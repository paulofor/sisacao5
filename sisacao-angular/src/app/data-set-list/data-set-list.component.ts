import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { DataSetEditComponent } from '../data-set-edit/data-set-edit.component';
import { DataSetApi } from '../shared/sdk';

@Component({
  selector: 'app-data-set-list',
  templateUrl: './data-set-list.component.html',
  styleUrls: ['./data-set-list.component.css']
})
export class DataSetListComponent extends BaseListComponent  {

  constructor(protected dialog: MatDialog, protected srv:DataSetApi) {
    super(dialog, srv);
  }

  getComponente() {
    return DataSetEditComponent;
  }

}
