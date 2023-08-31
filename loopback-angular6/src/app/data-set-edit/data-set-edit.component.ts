import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { BaseEditComponent } from '../base-component/base-edit-component';
import { DataSet, DataSetApi } from '../shared/sdk';

@Component({
  selector: 'app-data-set-edit',
  templateUrl: './data-set-edit.component.html',
  styleUrls: ['./data-set-edit.component.css']
})
export class DataSetEditComponent extends BaseEditComponent implements OnInit {

  constructor(protected dialogRef: MatDialogRef<DataSetEditComponent>
    , @Inject(MAT_DIALOG_DATA) protected data: any, protected servico: DataSetApi,
  ) {
    super(dialogRef, data, servico);
  }


  criaItem() {
    return new DataSet();
  }

}
