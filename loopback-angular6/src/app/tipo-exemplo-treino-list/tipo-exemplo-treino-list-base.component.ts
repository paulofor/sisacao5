import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute } from "@angular/router";
import { TipoExemploTreino , TipoExemploTreinoApi } from "../shared/sdk";
import { TipoExemploTreinoEditComponent } from "../tipo-exemplo-treino-edit/tipo-exemplo-treino-edit.component";

export class TipoExemploTreinoListBaseComponent implements OnInit {
	principal: TipoExemploTreino;
	listaBase:TipoExemploTreino[]
	idPrincipal: number;
	constructor(protected srv: TipoExemploTreinoApi, protected router: ActivatedRoute, protected dialog: MatDialog) { }

	ngOnInit() {
    	this.preCarregaTela();
       	this.carregaTela();
   	}

    preCarregaTela() {}
	posCarregaLista() {}

    carregaTela() {
        this.srv.find(this.getFiltro())
	     .subscribe((result:TipoExemploTreino[]) => {
            console.log('result: ' , result);
            this.listaBase = result;
            this.posCarregaLista();
        })
    }

	edita(edicao?) {
		this.dialog.afterAllClosed.subscribe(result => {
			this.carregaTela();
		});
		this.dialog.open(this.getComponente(), {
			width: '800px',
			data: {
				item: edicao
			}
		});
	}
	getComponente() : any {
		return TipoExemploTreinoEditComponent
	}


	dialogo1(dados) {
        console.log('dialogo1.dados:' , dados);
        this.dialog.afterAllClosed.subscribe(result => {
            this.carregaTela();
        });
        this.dialog.open(this.getDialogo1(), {
            width: '800px',
            data: dados
        });
	}
	getDialogo1() : any {
	}


    dialogo2(dados) {
    	console.log('dialogo2.dados:' , dados);
    	this.dialog.afterAllClosed.subscribe(result => {
 			this.carregaTela();
   		});
   		this.dialog.open(this.getDialogo2(), {
			width: '800px',
   			data: dados
  		});
  	}
 	getDialogo2() : any {
    }


	getFiltro() {
		return {}
	}
}
