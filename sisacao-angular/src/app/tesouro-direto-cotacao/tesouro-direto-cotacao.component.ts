import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseItemComListaComponent } from '../base-component/base-item-com-lista';
import { TesouroDiretoApi } from '../shared/sdk';

@Component({
  selector: 'app-tesouro-direto-cotacao',
  templateUrl: './tesouro-direto-cotacao.component.html',
  styleUrls: ['./tesouro-direto-cotacao.component.css']
})
export class TesouroDiretoCotacaoComponent extends BaseItemComListaComponent {

  constructor(protected srv:TesouroDiretoApi, protected router: ActivatedRoute) { 
    super(srv,router);
  }  

  getFiltro() {
    return {
      'include' : {'relation' : 'tesouroDiretoCotacaos'}
    }

  }

  setListaBase() {
    
  };
}
