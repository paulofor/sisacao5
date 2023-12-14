import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute } from "@angular/router";
import { FechamentoRegraDia , FechamentoRegraDiaApi } from "../shared/sdk";

export class FechamentoRegraDiaDetalheBaseComponent implements OnInit {
	principal: FechamentoRegraDia;
	idPrincipal: number;
	constructor(protected srv: FechamentoRegraDiaApi, protected router: ActivatedRoute, protected dialog: MatDialog) { }

	posCarregaTela() {}

	ngOnInit() {
		this.carregaTela()
	}
	carregaTela() {
		this.router.params.subscribe((params) => {
		this.idPrincipal = params['id'];
		this.srv.findById(this.idPrincipal, this.getFiltro())
	 		.subscribe((result: FechamentoRegraDia) => {
				this.principal = result;
				console.log('principal:', this.principal);
            	this.posCarregaTela();
			})
		})
	}
	getFiltro() {
		return {}
	}
}
