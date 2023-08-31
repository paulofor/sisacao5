import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute } from "@angular/router";
import { FechamentoPontoSaida , FechamentoPontoSaidaApi } from "../shared/sdk";

export class FechamentoPontoSaidaDetalheBaseComponent implements OnInit {
	principal: FechamentoPontoSaida;
	idPrincipal: number;
	constructor(protected srv: FechamentoPontoSaidaApi, protected router: ActivatedRoute, protected dialog: MatDialog) { }

	ngOnInit() {
		this.carregaTela()
	}
	carregaTela() {
		this.router.params.subscribe((params) => {
		this.idPrincipal = params['id'];
		this.srv.findById(this.idPrincipal, this.getFiltro())
	 		.subscribe((result: FechamentoPontoSaida) => {
				this.principal = result;
				console.log('principal:', this.principal);
			})
		})
	}
	getFiltro() {
		return {}
	}
}
