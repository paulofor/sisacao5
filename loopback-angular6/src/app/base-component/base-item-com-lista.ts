import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute } from "@angular/router";
import { PERCENTUAL_AVISO } from "../constantes/base.url";

import { BaseLoopBackApi } from "../shared/sdk";

export class BaseItemComListaComponent implements OnInit {

  listaBase: any[];
  principal: any;
  idPrincipal: number;

  constructor(protected srv: BaseLoopBackApi, protected router: ActivatedRoute, protected dialog: MatDialog) { }


  ngOnInit() {
    this.preCarregaTela();
    this.carregaTela();
  }

  preCarregaTela() { }
  posCarregaLista() { }

  carregaTela() {
    this.router.params.subscribe((params) => {
      this.idPrincipal = params['id'];
      this.srv.findById(this.idPrincipal, this.getFiltro())
        .subscribe((result: any) => {
          this.principal = result;
          console.log('principal:', this.principal);
          this.setListaBase();
        })
    })

  }

  setListaBase() { };

  getFiltro() {
    return {}
  }

  edita(ent_origem,edicao?) {
    this.dialog.afterAllClosed.subscribe(result => {
      this.carregaTela();
    });
    this.dialog.open(this.getComponente(), {
      width: '800px',
      data: {
        item: edicao,
        origem: ent_origem
      }
    });
  }

  getComponente() : any{

  }

  percentual(valorPerc, valor) {
    let result = ((valorPerc - valor) / valor) * 100;
    return result.toFixed(1);
  }
  verificaMarcaTexto(valorPerc, valor): string {
    let perc = ((valorPerc - valor) / valor) * 100;
    if (perc <= PERCENTUAL_AVISO && perc >= (PERCENTUAL_AVISO * -1)) {
      return "dgc-marcatexto"
    } else {
      return "";
    }
  }
}