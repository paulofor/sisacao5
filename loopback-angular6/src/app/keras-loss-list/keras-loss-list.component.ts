import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { KerasLossEditComponent } from '../keras-loss-edit/keras-loss-edit.component';
import { KerasLossApi } from '../shared/sdk';

@Component({
  selector: 'app-keras-loss-list',
  templateUrl: './keras-loss-list.component.html',
  styleUrls: ['./keras-loss-list.component.css']
})
export class KerasLossListComponent extends BaseListComponent {

  constructor(protected dialog: MatDialog, protected srv:KerasLossApi,public router: Router) { 
    super(dialog,srv)
  }


  getFiltro(): {} {
      return {}
  }
  
  
  getComponente() {
      return KerasLossEditComponent;
  }
}