import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { StartupFundoApi } from '../shared/sdk';
import { StartupEmpresaEditComponent } from '../startup-empresa-edit/startup-empresa-edit.component';
import { StartupFundoEditComponent } from '../startup-fundo-edit/startup-fundo-edit.component';
import { StartupInvestimentoEditComponent } from '../startup-investimento-edit/startup-investimento-edit.component';

@Component({
  selector: 'app-startup-fundo-list',
  templateUrl: './startup-fundo-list.component.html',
  styleUrls: ['./startup-fundo-list.component.css']
})
export class StartupFundoListComponent extends BaseListComponent {


 

  constructor(protected srv:StartupFundoApi, protected dialog: MatDialog) {
    super(dialog, srv);
  }

  getComponente() {
    return StartupFundoEditComponent;
  }
  


}
