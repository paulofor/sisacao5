package coletorjava.modelo.derivadas;

import br.com.digicom.lib.*;

import coletorjava.modelo.*;

public class OpcaoSisacaoSerieDerivada implements OpcaoSisacaoSerieDerivadaI {
	
	private OpcaoSisacaoSerie principal;
	private long qtdeOpcao = 0;

	public OpcaoSisacaoSerieDerivada(OpcaoSisacaoSerie itemPrincipal) {
		principal = itemPrincipal;
	}

	@Override
	public long getQuantidadeOpcao() {
		return qtdeOpcao;
	}

	@Override
	public void setQuantidadeOpcao(long dado) {
		qtdeOpcao = dado;

	}
}
