import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BaseListComponent } from '../base-component/base-list-component';
import { TesouroDiretoApi } from '../shared/sdk';

@Component({
  selector: 'app-tesouro-direto-lista',
  templateUrl: './tesouro-direto-lista.component.html',
  styleUrls: ['./tesouro-direto-lista.component.css']
})
export class TesouroDiretoListaComponent extends BaseListComponent {


 

  constructor(protected srv:TesouroDiretoApi, protected dialog: MatDialog) {
    super(dialog, srv);
  }

  
  
  getFiltro() {
    return {'order' : 'nome'}
  }


}
