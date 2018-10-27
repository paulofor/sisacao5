package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class ExperimentoOpcaoCurtoPrazoDerivada   implements ExperimentoOpcaoCurtoPrazoDerivadaI { 
  private ExperimentoOpcaoCurtoPrazo principal;
      public ExperimentoOpcaoCurtoPrazoDerivada( ExperimentoOpcaoCurtoPrazo itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
