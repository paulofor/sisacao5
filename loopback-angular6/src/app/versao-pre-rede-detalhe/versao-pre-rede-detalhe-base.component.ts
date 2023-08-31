import { OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute } from "@angular/router";
import { VersaoPreRede , VersaoPreRedeApi } from "../shared/sdk";

export class VersaoPreRedeDetalheBaseComponent implements OnInit {
	principal: VersaoPreRede;
	idPrincipal: number;
	constructor(protected srv: VersaoPreRedeApi, protected router: ActivatedRoute, protected dialog: MatDialog) { }

	ngOnInit() {
		this.carregaTela()
	}
	carregaTela() {
		this.router.params.subscribe((params) => {
		this.idPrincipal = params['id'];
		this.srv.findById(this.idPrincipal, this.getFiltro())
	 		.subscribe((result: VersaoPreRede) => {
				this.principal = result;
				console.log('principal:', this.principal);
			})
		})
	}
	getFiltro() {
		return {}
	}
}
