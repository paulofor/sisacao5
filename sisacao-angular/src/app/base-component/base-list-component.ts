import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material";
import { BaseLoopBackApi } from "../shared/sdk";

export class BaseListComponent implements OnInit {

    listaBase: any[];

    constructor(protected dialog: MatDialog, protected srv:BaseLoopBackApi) { }


    ngOnInit() {
        this.srv.find(this.getFiltro())
            .subscribe((result:any[]) => {
                console.log('result: ' , result);
                this.listaBase = result;
            })
    }

    edita(edicao?) {
        //this.dialog.afterAllClosed.subscribe(result => {
        //    this.carrega();
        //});
        this.dialog.open(this.getComponente(), {
            width: '800px',
            data: {
                item: edicao
            }
        });
    }

    getComponente():any {}

    getFiltro() {
        return {}
    }
}