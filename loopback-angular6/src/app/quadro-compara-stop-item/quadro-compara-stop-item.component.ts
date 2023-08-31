import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { StringifyOptions } from 'querystring';
import { BaseListComponent } from '../base-component/base-list-component';
import { RegraProjecaoApi } from '../shared/sdk';

@Component({
  selector: 'app-quadro-compara-stop-item',
  templateUrl: './quadro-compara-stop-item.component.html',
  styleUrls: ['./quadro-compara-stop-item.component.css']
})
export class QuadroComparaStopItemComponent  extends BaseListComponent {

  @Input() dado:any;
  @Input() tipo:string;

  exibeLoading : boolean = false;

  constructor(protected dialog: MatDialog, protected srv:RegraProjecaoApi, private router: ActivatedRoute) { 
    super(dialog,srv);
  }

  atualiza() {
    this.exibeLoading = true;
    this.srv.AtualizaDadosRegraProjecao()
      .subscribe((result) => {
        this.carregaTela();
        this.exibeLoading = false;
      })
  }

 
  saldo(item,posicao) {
    let lucro = item.regraProjecaoTotalMes[posicao].quantidadeLucro * (1+item.target);
    let prejuizo = item.regraProjecaoTotalMes[posicao].quantidadePrejuizo * (1-item.stop)
    return (lucro-prejuizo).toFixed(0);
  }


  getFiltro() {
    console.log('Tipo' , this.dado.tipo);
    console.log('Target' , this.dado.target);
    return {
      'where' : { 'and' : [{'diaLimite':260},{'target' : this.dado.target},{'tipoCompraVenda' : this.dado.tipo }] },
      'order' : 'stop',
      'include' : { 
        'relation' : 'regraProjecaoTotalMes' , 
        'scope' : {
          'order' : 'anoMesNum desc',
          'limit' : 3
        }
      }
    }
    
  }


}