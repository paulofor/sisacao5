import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";

import { BaseLoopBackApi } from "../shared/sdk";

export class BaseListComponent implements OnInit {

    listaBase: any[];

    constructor(protected dialog: MatDialog, protected srv:BaseLoopBackApi) { }


    ngOnInit() {
       this.carregaTela();
    }

    carregaTela() {
        this.srv.find(this.getFiltro())
        .subscribe((result:any[]) => {
            console.log('result: ' , result);
            this.listaBase = result;
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

    getComponente():any {}

    getFiltro() {
        return {}
    }
}