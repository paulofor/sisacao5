package coletorjava.modelo.derivadas;

import br.com.digicom.lib.*;

import coletorjava.modelo.*;

public class CotacaoDerivada implements CotacaoDerivadaI {
	private Cotacao principal;
	
	private String nomeTicker = null;

	public CotacaoDerivada(Cotacao itemPrincipal) {
		principal = itemPrincipal;
	}

	@Override
	public String getLinhaLog() {
		return principal.getData() + "(Neg:" + principal.getHoraNeg() + " Real:" + principal.getHoraReal() + ") : "
				+ principal.getUltFormatada();
	}

	@Override
	public void setLinhaLog(String dado) {
	}

	public String getNomeTicker() {
		return nomeTicker;
	}

	public void setNomeTicker(String value) {
		nomeTicker = value;
	}
}
