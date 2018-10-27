package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class EscolhaOpcaoDerivada   implements EscolhaOpcaoDerivadaI { 
  private EscolhaOpcao principal;
      public EscolhaOpcaoDerivada( EscolhaOpcao itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
