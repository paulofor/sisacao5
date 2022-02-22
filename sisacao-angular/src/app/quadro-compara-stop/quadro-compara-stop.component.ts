import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { BaseListComponent } from '../base-component/base-list-component';
import { RegraProjecaoApi } from '../shared/sdk';

@Component({
  selector: 'app-quadro-compara-stop',
  templateUrl: './quadro-compara-stop.component.html',
  styleUrls: ['./quadro-compara-stop.component.css']
})
export class QuadroComparaStopComponent  extends BaseListComponent {

  target = 0.15;
  tipo = 'C';

  constructor(protected dialog: MatDialog, protected srv:RegraProjecaoApi, private router: ActivatedRoute) { 
    super(dialog,srv);
  }

  atualiza() {
    this.srv.AtualizaDadosRegraProjecao()
      .subscribe((result) => {
        this.carregaTela();
      })
  }

  preCarregaTela() {
    this.router.params.subscribe((params) => {
      this.target = (params['target']/100);
      this.tipo = params['tipo']; 
    })
  }
 
  saldo(item,posicao) {
    let lucro = item.regraProjecaoTotalMes[posicao].quantidadeLucro * (1+item.target);
    let prejuizo = item.regraProjecaoTotalMes[posicao].quantidadePrejuizo * (1-item.stop)
    return (lucro-prejuizo).toFixed(0);
  }


  getFiltro() {
    return {
      'where' : { 'and' : [{'target' : this.target},{'tipoCompraVenda' : this.tipo }] },
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