import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { KerasOptimizerEditComponent } from '../keras-optimizer-edit/keras-optimizer-edit.component';
import { KerasOptimizerApi } from '../shared/sdk';

@Component({
  selector: 'app-keras-optimizer-list',
  templateUrl: './keras-optimizer-list.component.html',
  styleUrls: ['./keras-optimizer-list.component.css']
})
export class KerasOptimizerListComponent  extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:KerasOptimizerApi,public router: Router) { 
    super(dialog,srv)
  }


  getFiltro(): {} {
      return {}
  }
  
  
  getDialogo1() {
      return KerasOptimizerEditComponent;
  }
}